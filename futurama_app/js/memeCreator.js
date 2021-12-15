$(document).ready(function () {
  var imgBox1 = $("#imgBox1");
  imgBox1.hide();

  var imgBox2 = $("#imgBox2");
  imgBox2.hide();

  var imgBox3 = $("#imgBox3");
  imgBox3.hide();

  var imgBox4 = $("#imgBox4");
  imgBox4.hide();

  var input1 = $("#input1");
  var input2 = $("#input2");

  var setInput1 = $("#setInput1");
  var setInput2 = $("#setInput2");

  setInput1.hide();
  setInput2.hide();

  $("#img1").click(function () {
    imgBox2.hide();
    imgBox3.hide();
    imgBox4.hide();

    imgBox1.show();
  });

  $("#img2").click(function () {
    imgBox1.hide();
    imgBox3.hide();
    imgBox4.hide();

    imgBox2.show();
  });

  $("#img3").click(function () {
    imgBox1.hide();
    imgBox2.hide();
    imgBox4.hide();

    imgBox3.show();
  });

  $("#img4").click(function () {
    imgBox1.hide();
    imgBox2.hide();
    imgBox3.hide();

    imgBox4.show();
  });

  $("#create").click(function () {
    var in1 = input1.val();
    var in2 = input2.val();

    setInput1.val(in1);
    setInput2.val(in2);

    setInput1.show();
    setInput2.show();
  });

});
