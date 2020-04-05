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

function handleStarResult(resultData) {
    // Populate the star table
    // Find the empty table body by id "star_table_body"
    let starTableBodyElement = jQuery("#movie_table_body");

    console.log(resultData)
    for(let i = 0; i < Math.min(20, resultData.length); ++i) {
        let record ="<tr>";
        record += "<th>" + resultData[i]["title"] + "</th>";
        record += "<th>" + resultData[i]["year"] + "</th>";
        record += "<th>" + resultData[i]["director"] + "</th>";

        // add genres
        record += "<th>";
        for (let j = 0; j < Math.min(3, getLength(resultData[i]["genres"])); ++j) {
            record += resultData[i]["genres"][j]["name"] + " ";
        }
        record += "</th>";

        // add stars
        record += "<th>";
        for (let k = 0; k < Math.min(3, getLength(resultData[i]["stars"])); ++k) {
            record += '<a href="single-star.html?id=' + resultData[i]["stars"][k]["id"] + '">'
                + resultData[i]["stars"][k]["name"] +
                '</a>' + " ";
        }
        record += "</th>";

        record += "<th>" + resultData[i]["rating"] + "</th>";

        record += "</tr>";

        starTableBodyElement.append(record);
    }
}

// Makes the HTTP GET request and registers on success callback function handleStarResult
jQuery.ajax({
    dataType: "json", // Setting return data type
    method: "GET", // Setting request method
    url: "api/movie-list", // Setting request url, which is mapped by StarsServlet in Stars.java
    success: (resultData) => handleStarResult(resultData) // Setting callback function to handle data returned successfully by the StarsServlet
});