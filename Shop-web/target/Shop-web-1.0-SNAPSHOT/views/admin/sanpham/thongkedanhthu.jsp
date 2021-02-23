<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2020
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script>
    window.onload = function () {
        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            title: {
                text: "Thống kê Danh thu bán theo Tháng"
            },
            axisY: {
                title: "Số tiền"
            },
            axisX: {
                title: "Tháng"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                dataPoints: ${demon}
            }]
        });
        chart.render();
    }
</script>
