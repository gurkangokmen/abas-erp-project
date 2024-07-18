
Request:
```
http://localhost:8080/task?siparisler=1000&siparisler=1001&siparisler=1002
```
Response:
```
69621.41799999999 //200 OK
```

Request:
```
http://localhost:8080/task/ortalama?siparisler=1000&siparisler=1001&siparisler=1002
```
Response:
```
4641.427866666666 //200 OK
```

Request:
```
http://localhost:8080/task/ortalamaFiyatMal?siparisler=1000&siparisler=1001&siparisler=1002
```
Response:
```
{
    "2000": 100.51,
    "2001": 122.2655,
    "2002": 105.27000000000001,
    "2003": 91.40000000000002,
    "2004": 159.1,
    "2005": 44.1,
    "2006": 90.0
} //200 OK
```

Request:
```
http://localhost:8080/task/countAndSiparisNumarasi?malId=2002
```
Response:
```
[
    [
        1,
        1000
    ],
    [
        2,
        1001
    ],
    [
        1,
        1002
    ]
] //200 OK
```