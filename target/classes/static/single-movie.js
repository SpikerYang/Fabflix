/**
 * This .js performs two steps:
 *      1. Use jQuery to talk to backend API to get the json data.
 *      2. Populate the data to correct html elements.
 */

/**
 * Handles the data returned by server, populate data into html elements
 * @param resultData:
 * star_id;
 * star_name
 * star_birthYear
 *
 */
function getLength(jsonData) {
    let count = 0;
    for (var i in jsonData) count++;
    return count;
}

function getParameterByName(target) {
    // Get request URL
    let url = window.location.href;
    // Encode target parameter name to url encoding
    target = target.replace(/[\[\]]/g, "\\$&");

    // Ues regular expression to find matched parameter value
    let regex = new RegExp("[?&]" + target + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';

    // Return the decoded parameter value
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function handleStarResult(resultData) {
    // Populate the star table
    // Find the empty table body by id "star_table_body"
    let starTableBodyElement = jQuery("#movie_info");

    console.log(resultData)
    let record =
        "<p>Movie Title: " + resultData["title"] + "</p>" +
        "<p>Release Year: " + resultData["year"]  +"</p>" +
        "<p>Director: " + resultData["director"]  +"</p>" +
        "<p>Rating: " + resultData["rating"]  +"</p>";

    // add genres
    record += "<p>Genres: ";
    for (let j = 0; j < getLength(resultData["genres"]); ++j) {
        record += resultData["genres"][j]["name"] + " ";
    }
    record += "</p>";

    // add stars
    record += "<p>Stars: ";
    for (let k = 0; k < getLength(resultData["stars"]); ++k) {
        record += '<a href="single-star.html?id=' + resultData["stars"][k]["id"] + '">'
            + resultData["stars"][k]["name"] +
            '</a>' + " ";
    }
    record += "</p>";

    starTableBodyElement.append(record);
}
// Get id from URL
let movieId = getParameterByName('id');

// Makes the HTTP GET request and registers on success callback function handleStarResult
jQuery.ajax({
    dataType: "json", // Setting return data type
    method: "GET", // Setting request method
    url: "api/single-movie/" + movieId, // Setting request url, which is mapped by StarsServlet in Stars.java
    success: (resultData) => handleStarResult(resultData) // Setting callback function to handle data returned successfully by the StarsServlet
});