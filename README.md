# pantry-service

## Description
This Spring project integrates database models and requests to realize a pantry documentation frontend. With the expiry date you can watch food that has to be eaten in the closer future. 

## Models
### Location
Describes a place where the item is stored, like a fridge.

```
Location{
  id	integer($int64)
  name	string
}
```

*Example:*
```json
{
    "id": 0,
    "name": "string"
}
```


### Category
Describes a category where the item can be sorted in, like fruits.

```
Category{
  id	integer($int64)
  name	string
}
```

*Example:*
```json
{
    "id": 0,
    "name": "string"
}
```


### Item
This is the item you are going to work with.

```
Item{
  id	integer($int64)
  description	string
  amount	integer($int32)
  quantity	string
  expiryDate	string($date-time)
  location	Location{
    id	  integer($int64)
    name	string
  }
  category	Category{
    id	  integer($int64)
    name	string
  }
}
```

*Example:*
```json
{
    "id": 0,
    "description": "string",
    "amount": 0,
    "quantity": "string",
    "expiryDate": "2022-03-11T21:11:20.363Z",
    "location": {
        "id": 0,
        "name": "string"
    },
    "category": {
        "id": 0,
        "name": "string"
    }
}
```

## Requests

### /api/v1/location/

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/category/

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/location/name/{name}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/location/like/{name}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/location/id/{id}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/location

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| location | query |  | Yes | [Location](#Location) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/like/{description}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| description | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/id/{id}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/expired

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/description/{description}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| description | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/category

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| category | query |  | Yes | [Category](#Category) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/category/name/{name}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/category/like/{name}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/category/id/{id}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/location/{id}

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/item/{id}

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/category/{id}

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
