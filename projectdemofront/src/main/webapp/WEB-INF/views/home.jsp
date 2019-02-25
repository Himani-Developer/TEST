
<style>
.flip-box {
  background-color: transparent;
  /* width: 300px;
  height: 200px; */
  border: 1px solid #f1f1f1;
  perspective: 1000px;
}

.flip-box-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

.flip-box:hover .flip-box-inner {
  transform: rotateY(180deg);
}

.flip-box-front, .flip-box-back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
}

.flip-box-front {
  background-color: #bbb;
  color: black;
}

.flip-box-back {
  background-color: #555;
  color: white;
  transform: rotateY(180deg);
}
</style>


<%@include file="templates/navbar.jsp" %>

<%@include file="templates/carousel.jsp" %>

<div class="container-fluid">
<div class="row">
<div class="col-sm-8">


<div class="flip-box">
  <div class="flip-box-inner">
    <div class="flip-box-front">
      <img src="resources/images/Christmas_Collection_Header_-_Winter_Wonderland_600x600.jpg" alt="nature image " class=img-fluid width="100%" height="300" style="border-radius: 20%;"/>
    </div>
    <div class="flip-box-back">
      <h2>Welcome</h2>
      <p>Variety of bags are here </p>
    </div>
  </div>
</div>



</div>

<!-- <div class="col-sm-4">
<img src="resources/images/sale-bag-vector-seasonal-shopping-bags-illustration-32589445.jpg" alt="nature image " class=img-fluid width="100%" height="300">
</div>
</div>
</div>
 -->



<div class="col-sm-4">

<div class="container-fluid">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides    -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/images/sale-bag-vector-seasonal-shopping-bags-illustration-32589445.jpg" alt="image1" style="width:100%;height:300px;">
      </div>

      <div class="item">
        <img src="resources/images/sale1.png" alt="image2" style="width:100%;height:300px;">
      </div>
    
      <div class="item">
        <img src="resources/images/sale2.jpg" alt="image3" style="width:100%;height:300px;">
      </div>
      
      
    

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>
</div>
</div>
</div>