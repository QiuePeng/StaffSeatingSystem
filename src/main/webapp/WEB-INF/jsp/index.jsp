<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/seat.css">

<meta charset="UTF-8">
<title>員工座位系統</title>
</head>
<body>
   <div class="main">
      <select class="emp_wrap" id="employeeId">
          <div class="emp_info">
              <option selected disabled>請選擇員工</option>
              <c:forEach var="employee" items="${employee}">
              	<option value="${employee.EMP_ID}">${employee.NAME}</option>
              </c:forEach>
          </div>
      </select>
	      <div class="seat_wrap">
		      <c:forEach var="seatChart" items="${seatChart}">
		          <div class="seat" id="seat" value="${seatChart.FLOOR_SEAT_SEQ}" data-floor-seat-seq="${seatChart.FLOOR_SEAT_SEQ}" data-employee-id="${seatChart.employee.EMP_ID}">
		              <div class="seat_info">
		                  <span class="floor_no">${seatChart.FLOOR_NO}樓</span>
		                  <span class="seat_no">座位${seatChart.SEAT_NO}</span>	
		              </div>
		          </div>
		      </c:forEach>
	      </div>
      <div class="color_wrap">
          <div class="color_info">
              <div class="color_box"></div>
              <span>空位</span>
          </div>
          <div class="color_info">
              <div class="color_box_red"></div>
              <span>已占用</span>
          </div>
          <div class="color_info">
              <div class="color_box_green"></div>
              <span>請選擇</span>
          </div>
      </div>

      <button class="btn" id="btn">送出</button>

  </div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>




var selectedSeat = null;
var selectedSeatValue = null; 
$('.seat').click(function() {
	
	var seat = $(this);
	var seatValue = $(this).attr("value");
	var backgroundColor = seat.css("background-color");
    if (backgroundColor === "rgb(201, 56, 56)") {
        return;
    }
	
    if (selectedSeat !== null) {
        selectedSeat.css("background-color", "#ebeaea");
    }
    seat.css("background-color", "#20db68");
    selectedSeat = seat;
    selectedSeatValue = seatValue;
});

$('#btn').click(function() {
	var employeeId = $("#employeeId").val();
	if(selectedSeatValue) {
		if(employeeId){
			$.ajax({
				url: 'http://localhost:8080/staffseating/reserveSeat',
				type: 'POST',
				data: {
					EMP_ID: employeeId,
					FLOOR_SEAT_SEQ: selectedSeatValue
				},
				success: function(response) {
					console.log(response);
					alert("登記成功");
					location.reload();
				},
		        error: function(error) {
					console.log(error);
		        }
			})	
		}else {
			alert("請選擇你的名字");
		}
	}else {
        alert("請選擇一個座位");
    }
});

$(document).ready(function() {
     $.ajax({
         type: "GET",
         url: "http://localhost:8080/staffseating/seatExist",
         success: function(response) {
        	 
             $(".seat").each(function() {
                 var floorSeatSeq = $(this).data("floor-seat-seq");

                 if (response.includes(floorSeatSeq)) {
                     $(this).css("background-color", "#c93838");
                     $(this).css("color", "#fff");
                     var employeeId = $(this).data("employee-id");
                     $(this).find(".seat_info").append("<span class='employee-id'>" + "[員編:" + employeeId + "]" + "</span>");
                 }
             });
         },
         error: function() {
             alert("發生错误！");
         }
     });
});




</script>


</body>

</html>