## DataBase
MySQL 8.0 (AWS RDS 이용)

## 배포 URL
AWS EC2 배포 <br>
base: http://13.125.205.226:8080/ 현재 서버 API 주소<br>
(프론트 구현 예정)<br>
docker (배포 예정)


# API 명세서

## User

#### URL Structure
`http://.../api/user`

#### Description
이름으로 간편한 로그인.

#### Method
POST

#### Body
| Variable |  | Type | What |
|---|---|---|----|
| **name** | *Required* | String |  User's Name  |

```
{
    "name": "jino😳"
}
```

#### Returns
```
{
    "status_code": 200,
    "message": "로그인 되었습니다.",
    "data": {
        "id" : 1,
        "name" : "jino😳"
    }
}
```


#### URL Structure
`http://.../api/:id/basket`

#### Description
해당하는 유저의 장바구니 조회

#### Method
GET

#### Path Variable
| Variable |  | Type | What |
|---|---|---|----|
| **id** | *Required* | String |  User's id  |

#### Returns
```
{
    "status_code": 200,
    "message": "",
    "data":
        [
            { 
                "order_id" : 1,
                "order_name" : "감자",
                "url" : "http://localhost:8080/api/files/1",
                "price" : 10000,
                "count" : 1000
            },
            {
                "order_id: 2,
                "order_name" : "토마토",
                "url" : "http://localhost:8080/api/files/2",
                "price" : 10000,
                "count" : 1000
            }
            .
            .
            .
        ]
}
```



#### URL Structure
`http://.../api/user/:id/basket/:order_id`

#### Description
유저가 장바구니에 리스트를 담음.

#### Method
GET

#### Path Variable
| Variable |  | Type | What |
|---|---|---|----|
| **id** | *Required* | String |  User's Id  |
| **order_id** | *Required* | String |  Order's Id  |


#### Returns
```
{
    "status_code": 200,
    "message": "장바구니에 담았습니다.",
    "data": null
}
```

#### Error (중복으로 담을 때)
```
{
    "status_code": 400,
    "message": "중복으로 담을 수 없습니다!!",
    "data": null
}
```


#### URL Structure
`http://.../api/user/:id/basket/:order_id`

#### Description
유저가 장바구니에 리스트를 삭제함.

#### Method
DELETE

#### Path Variable
| Variable |  | Type | What |
|---|---|---|----|
| **id** | *Required* | String |  User's Id  |
| **order_id** | *Required* | String |  Order's Id  |


#### Returns
```
{
    "status_code": 200,
    "message": "삭제에 성공했습니다.",
    "data": null
}
```

#### Error (없는데 삭제 할 때)
```
{
    "status_code": 400,
    "message": "삭제에 실패했습니다.",
    "data": null
}
```



## Order_list

#### URL Structure
`http://.../api/order_list`

#### Description
주문 리스트 조회

#### Method
GET

#### Returns
```
{
    "status_code": 200,
    "message": "",
    "data":
        [
            { 
                "order_id" : 1,
                "order_name" : "감자",
                "url" : "http://localhost:8080/api/files/1",
                "price" : 10000,
                "count" : 1000
            },
            {
                "order_id: 2,
                "order_name" : "토마토",
                "url" : "http://localhost:8080/api/files/2",
                "price" : 10000,
                "count" : 1000
            },
            {
                .
                .
                .
        ]
}
```



#### URL Structure
`http://.../api/order_list/:id`


#### Path Variable
| Variable |  | Type | What |
|---|---|---|----|
| **id** | *Required* | String |  Order's Id  |


#### Description
주문 리스트 중 하나 조회

#### Method
GET

#### Returns
```
{
    "status_code": 200,
    "message": "",
    "data": 
    {
        "order_id" : 1,
        "order_name" : "감자",
        "price" : 10000,
        "count" : 1000
    }
}
```

## Basket

#### URL Structure
`http://.../api/order_list/:id`

#### Path Variable
| Variable |  | Type | What |
|---|---|---|----|
| **id** | *Required* | String |  basket's Id  |


#### Description
장바구니 삭제

#### Method
DELETE

#### Returns
```
{
    "status_code": 200,
    "message": "장바구니에서 삭제 되었습니다.",
    "data": null
}
```

