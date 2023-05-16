/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
  .print("hello world.");
  makeArtifact("hue_artifact", "emas.HueArtifact", ["http://localhost:8080/emas-hue/"], ArtID);
  .print("Hue artifact created with id: ", ArtID);
  focusWhenAvailable("hue_artifact");
  turnLightOn[artifact_name("hue_artifact")];
  // turnLightOn;
  .print("Light turned on").

