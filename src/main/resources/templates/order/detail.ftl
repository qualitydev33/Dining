<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--Navbar-->
        <#include "../common/nav.ftl">

    <#--Content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Order id</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.orderAmount}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Product id</th>
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Number</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.orderDetailList as orderDetail>
                            <tr>
                                <td>${orderDetail.productId}</td>
                                <td>${orderDetail.productName}</td>
                                <td>${orderDetail.productPrice}</td>
                                <td>${orderDetail.productQuantity}</td>
                                <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <#if orderDTO.getOrderStatusEnum().message == "New">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">Finish</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">Cancel</a>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>