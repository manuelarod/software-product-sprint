// Copyright 2020 Google LLC
//
// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
**/
function addRandomFact() {
  const facts =
      ["I've lived in three different countries", 
      "I'm a vegetarian", 
      "My favorite Sunday activity is watching Formula 1", 
      "I love cooking and doing yoga"];

  // Pick a random greeting.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

/** Adds hard-coded string to the page. */
async function showGreetingMessage() {
    const responseFromServer = await fetch('/intro');
    const textFromResponse = await responseFromServer.text();
    
    const introContainer = document.getElementById('intro-container');
    introContainer.innerText = textFromResponse;
}


async function randomGreeting() {
    // Send a request to /my-data-url.
    const responseFromServer = await fetch('/intro');

    // Parse the response as JSON.
    const myObject = await responseFromServer.json();

    const greetingContainer = document.getElementById('greeting-container');
    //greetingContainer.innerText = myObject;

    // Now we can reference the fields in myObject!
    console.log(myObject);
    console.log("random greeting succesful");
}

