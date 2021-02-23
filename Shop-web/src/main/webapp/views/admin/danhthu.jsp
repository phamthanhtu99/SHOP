<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="timkiem" value="/admin-danhthuch.html">
</c:url>
<div class="row" >
        <form class="ml-5 mt-2" method="get" action="${timkiem}">
            <label  for="bdaymonth">Chọn Tháng và Năm:</label>
            <input  type="month" id="bdaymonth" name="ngaybatday" >
            <button type="submit" class="" >Chọn</button>
        </form>
</div>
<div class="row">
    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Danh thu Đã Bán</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><fmt:formatNumber value="${damua}"/> VNĐ
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Đã Hủy</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><fmt:formatNumber value="${dahuy}"/> VNĐ
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Số Tiền Đã Nhập</div>
                        <div class="row no-gutters align-items-center">
                            <div class="col-auto">
                                <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"> <fmt:formatNumber value="${stnhap}" /> VNĐ</div>
                            </div>
                            <div class="col">
                                <div class="progress progress-sm mr-2">
                                    <div class="progress-bar bg-info" role="progressbar" style="width: 50%"
                                         aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Pending Requests</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-comments fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

    <c:url value="/ajax-danhthuch.html" var="hienthi">
        <c:param name="urlType" value="hienthi"/>
    </c:url>
    <script>
        $(document).ready(function () {

        })
        function hienthi() {
            var url='${hienthi}';
            $('.hienthi').load(url);
        }

            window.onload = function () {
                var chart = new CanvasJS.Chart("chartContainer", {
                    animationEnabled: true,
                    theme: "light2", // "light1", "light2", "dark1", "dark2"
                    title: {
                        text: "Thống kê Doanh thu bán theo Tháng"
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
