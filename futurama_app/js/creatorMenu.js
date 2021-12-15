$(document).ready(function () {
  var skelEyes = $("#skelEyes");
  var skelHair = $("#skelHair");
  var skelMouth = $("#skelMouth");
 
  var skelBody = $("#skelBody");
  var skelLeftArm = $("#skelLeftArm");
  var skelRightArm = $("#skelRightArm");

  var skelLeg = $("#skelLeg");


for(var i=1; i<7; i++) {
  $("#eyes" + i).hide();
  $("#hair" + i).hide();
  $("#mouth" + i).hide();
  $("#body" + i).hide();
  $("#lArm" + i).hide();
  $("#rArm" + i).hide();
  $("#leg" + i).hide(); 
}
  

  $(".itemsToSelect").hide();

  $("#showMenuHair").click(function () {
    $(".itemsToSelect").hide();
    $("#hair").fadeIn();
  });

  $("#showMenuEyes").click(function () {
    $(".itemsToSelect").hide();
    $("#eyes").fadeIn();
  });

  $("#showMenuMouth").click(function () {
    $(".itemsToSelect").hide();
    $("#mouth").fadeIn();
  });

  $("#showMenuBody").click(function () {
    $(".itemsToSelect").hide();
    $("#body").fadeIn();
  });

  $("#showMenuArms").click(function () {
    $(".itemsToSelect").hide();
    $("#arms").fadeIn();
  });

  $("#showMenuLegs").click(function () {
    $(".itemsToSelect").hide();
    $("#legs").fadeIn();
  });

  $("#reset").click(function () {
    skelEyes.hide();
    skelHair.hide(); 
    skelMouth.hide();
    skelBody.hide();
    skelLeftArm.hide();
    skelRightArm.hide();
    skelLeg.hide();
   
    skelEyes = $("#skelEyes");
    skelHair = $("#skelHair");
    skelMouth = $("#skelMouth");
   
    skelBody = $("#skelBody");
    skelLeftArm = $("#skelLeftArm");
    skelRightArm = $("#skelRightArm");
  
    skelLeg = $("#skelLeg");

    skelEyes.fadeIn();
    skelHair.fadeIn();
    skelMouth.fadeIn();
    skelBody.fadeIn();
    skelLeftArm.fadeIn();
    skelRightArm.fadeIn();
    skelLeg.fadeIn();

  });

  //select eye
  $("#eyesSelected1").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes1");
    skelEyes.show();
  });


  $("#eyesSelected2").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes2");
    skelEyes.show();
  });

  $("#eyesSelected3").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes3");
    skelEyes.show();
  });


  $("#eyesSelected4").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes4");
    skelEyes.show();
  });

  $("#eyesSelected5").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes5");
    skelEyes.show();
  });

  $("#eyesSelected6").click(function () {
    skelEyes.hide();

    skelEyes = $("#eyes6");
    skelEyes.show();
  });


  //hair
  $("#hairSelected1").click(function () {
    skelHair.hide();

    skelHair = $("#hair1");
    skelHair.show();
  });

  $("#hairSelected2").click(function () {
    skelHair.hide();

    skelHair = $("#hair2");
    skelHair.show();
  });

  $("#hairSelected3").click(function () {
    skelHair.hide();

    skelHair = $("#hair3");
    skelHair.show();
  });

  $("#hairSelected4").click(function () {
    skelHair.hide();

    skelHair = $("#hair4");
    skelHair.show();
  });

  $("#hairSelected5").click(function () {
    skelHair.hide();

    skelHair = $("#hair5");
    skelHair.show();
  });

  //select mouth
  $("#mouthSelected1").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth1");
    skelMouth.show();
  });


  $("#mouthSelected2").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth2");
    skelMouth.show();
  });

  $("#mouthSelected3").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth3");
    skelMouth.show();
  });


  $("#mouthSelected4").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth4");
    skelMouth.show();
  });

  $("#mouthSelected5").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth5");
    skelMouth.show();
  });


  $("#mouthSelected6").click(function () {
    skelMouth.hide();

    skelMouth = $("#mouth6");
    skelMouth.show();
  });

    //select body
  
    $("#bodySelected1").click(function () {
      skelBody.hide();
  
      skelBody = $("#body1");
      skelBody.show();
    });

    $("#bodySelected2").click(function () {
      skelBody.hide();
  
      skelBody = $("#body2");
      skelBody.show();
    });

    $("#bodySelected3").click(function () {
      skelBody.hide();
  
      skelBody = $("#body3");
      skelBody.show();
    });

    $("#bodySelected4").click(function () {
      skelBody.hide();
  
      skelBody = $("#body4");
      skelBody.show();
    });

//select LeftArm
    
    $("#armsSelected1").click(function () {
      skelLeftArm.hide();
  
      skelLeftArm = $("#lArm1");
      skelLeftArm.show();
    });

    $("#armsSelected3").click(function () {
      skelLeftArm.hide();
  
      skelLeftArm = $("#lArm2");
      skelLeftArm.show();
    });

    $("#armsSelected5").click(function () {
      skelLeftArm.hide();
  
      skelLeftArm = $("#lArm3");
      skelLeftArm.show();
    });

    $("#armsSelected7").click(function () {
      skelLeftArm.hide();
  
      skelLeftArm = $("#lArm4");
      skelLeftArm.show();
    });


    // select Right Arm

    $("#armsSelected2").click(function () {
      skelRightArm.hide();
  
      skelRightArm = $("#rArm1");
      skelRightArm.show();
    });

    $("#armsSelected4").click(function () {
      skelRightArm.hide();
  
      skelRightArm = $("#rArm2");
      skelRightArm.show();
    });

    $("#armsSelected6").click(function () {
      skelRightArm.hide();
  
      skelRightArm = $("#rArm3");
      skelRightArm.show();
    });

    $("#armsSelected8").click(function () {
      skelRightArm.hide();
  
      skelRightArm = $("#rArm4");
      skelRightArm.show();
    });


    // select leg 

    $("#legsSelected1").click(function () {
      skelLeg.hide();
  
      skelLeg = $("#leg1");
      skelLeg.show();
    });

    $("#legsSelected2").click(function () {
      skelLeg.hide();
  
      skelLeg = $("#leg2");
      skelLeg.show();
    });

    $("#legsSelected3").click(function () {
      skelLeg.hide();
  
      skelLeg = $("#leg3");
      skelLeg.show();
    });

    $("#legsSelected4").click(function () {
      skelLeg.hide();
  
      skelLeg = $("#leg4");
      skelLeg.show();
    });

    $("#legsSelected5").click(function () {
      skelLeg.hide();
  
      skelLeg = $("#leg5");
      skelLeg.show();
    });

});
