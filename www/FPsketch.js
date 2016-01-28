/*global cordova, module*/

module.exports = {
    startSketch: function (existingPNGSketch, base64JsonArrayOfImages, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "FPSketch", "startSketch", [existingPNGSketch, base64JsonArrayOfImages]);
    }
};
