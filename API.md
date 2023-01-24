# API
### Get the list of products
```
GET /sellweb/buyer/product/list
```

```
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "name": "noodles",
            "type": 1,
            "foods": [
                {
                    "id": "123",
                    "name": "tomato pasta",
                    "price": 10.99,
                    "description": "delicious pasta",
                    "icon": "http://xxx.com",
                }
            ]
        },
        {
            "name": "pizza",
            "type": 5,
            "foods": [
                {
                    "id": "124",
                    "name": "tomato pizza",
                    "price": 12.99,
                    "description": "smell so good",
                    "icon": "http://xxx.com",
                }
            ]
        }
    ]
}
```
###Create Order

```
POST /sell/buyer/order/create
```

params

```
name: "buyer_name"
phone: "1234567890"
address: "xxx street"
openid: "xxxxxx" //user's username
items: [{
    productId: "123456",
    productQuantity: 2 
}]

```

return

```
{
  "code": 0,
  "msg": "success",
  "data": {
      "orderId": "1588368683873782362" 
  }
}
```

###Get the list of order

```
GET /sell/buyer/order/list
```

params

```
openid: xxxxxx
page: 0 //start from the first page
size: 10
```

return

```
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "orderId": "1588368683873782362",
      "buyerName": "buyer_name",
      "buyerPhone": "1234567890",
      "buyerAddress": "xxx street",
      "buyerOpenid": "xxxxxx",
      "orderAmount": 20,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1111111111,
      "updateTime": 1111111111,
      "orderDetailList": null
    },
    {
      "orderId": "1588366902773767266",
      "buyerName": "buyer_name",
      "buyerPhone": "1234567890",
      "buyerAddress": "xxx street",
      "buyerOpenid": "xxxxxx",
      "orderAmount": 30,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1111111111,
      "updateTime": 1111111111,
      "orderDetailList": null
    }]
}
```

###Get the detail of order

```
GET /sell/buyer/order/detail
```

params

```
openid: xxxxxx
orderId: 1588366902773767266
```

return

```
{
    "code": 0,
    "msg": "success",
    "data": {
          "orderId": "1588366902773767266",
          "buyerName": "buyer_name",
          "buyerPhone": "1234567890",
          "buyerAddress": "xxx street",
          "buyerOpenid": "xxxxxx",
          "orderAmount": 79.90,
          "orderStatus": 0,
          "payStatus": 0,
          "createTime": 1111111111,
          "updateTime": 1111111111,
          "orderDetailList": [
            {
                "detailId": "1588368683974872939",
                "orderId": "1588366902773767266",
                "productId": "123457",
                "productName": "potato pizza",
                "productPrice": 7.99,
                "productQuantity": 10,
                "productIcon": "http://xxx.com",
                "productImage": "http://xxx.com"
            }
        ]
    }
}
```

###Cancel order

```
POST /sell/buyer/order/cancel
```

params

```
openid: xxxxxxx
orderId: 1588366902773767266
```

return

```
{
    "code": 0,
    "msg": "success",
    "data": null
}
```