<html>

<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--Navbar-->
    <#include "../common/nav.ftl">

    <#--Content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>Order id</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Amount</th>
                            <th>Order status</th>
                            <th>Payment status</th>
                            <th>Create Time</th>
                            <th colspan="2">Operation</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAddress}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.getOrderStatusEnum().message}</td>
                                <td>${orderDTO.getPayStatusEnum().message}</td>
                                <td>${orderDTO.createTime}</td>
                                <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">Details</a></td>
                                <td>
                                    <#if orderDTO.getOrderStatusEnum().message == "New">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">Cancel</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">Previous</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">Previous</a></li>
                        </#if>

                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled"><a href="#">Next</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">Next</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<#--Pop up message-->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    Notification
                </h4>
            </div>
            <div class="modal-body">
                You have a new order
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">Reload</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    var websocket = null;
    if('WebSocket' in window) {
        websocket = new WebSocket('ws://localhost:8080/sell/webSocket');
    }else {
        alert("This browser doesn't support WebSocket!");
    }

    websocket.onopen = function (event) {
        console.log('Connected');
    }

    websocket.onclose = function (event) {
        console.log('Disconnected');
    }

    websocket.onmessage = function (event) {
        console.log('Receive a message:' + event.data)

        $('#myModal').modal('show');
    }

    websocket.onerror = function () {
        alert('websocket error！');
    }

    window.onbeforeunload = function () {
        websocket.close();
    }

</script>

</body>
</html>