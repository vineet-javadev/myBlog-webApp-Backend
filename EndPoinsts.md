# User API Endpoints

### Get all users
    1. http://localhost:8082/api/user ( GET )

    result :- 
    [
        {
            "userId": 2,
            "emailId": "Raju@gamil.com",
            "password": "raju123",
            "userName": "Raju",
            "userGender": "Male",
            "userNationality": "Indian",
            "userBio": "i am here to express myself or my views on raju's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        },
        {
            "userId": 3,
            "emailId": "vineet@gamil.com",
            "password": "vineetpass",
            "userName": "Vineet",
            "userGender": "Male",
            "userNationality": "Indian",
            "userBio": "i am here to express myself or my views",
            "userProfilePic": "default.png",
            "userCoverPicture": null
        }
    ]

### Get user Password

    2. http://localhost:8082/api/user/2 ( GET )

        result :- It will return password ( raju123 )

### Get a perticular user Details
    3. http://localhost:8082/api/user/userId/2 ( GET )

    result :-
    {
        "userId": 2,
        "emailId": "Raju@gamil.com",
        "password": "\***\*\*\*\*\*\*\***",
        "userName": "Raju",
        "userGender": "Male",
        "userNationality": "Indian",
        "userBio": "i am here to express myself or my views on raju's point of view",
        "userProfilePic": "default.png",
        "userCoverPicture": "default-cover.png"
    }

### add new user
    4. http://localhost:8082/api/user ( POST )
    { Body > raw > Json }

    Input :-
        {
            "emailId": "Rani@gamil.com",
            "password": "Rani1234",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "Indian",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }

    Output :-
        {
            "userId": 4,
            "emailId": "Rani@gamil.com",
            "password": "\***\*\*\*\*\*\*\***",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "Indian",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }

### Update user details
    5. http://localhost:8082/api/user/4 ( PUT )
        Input :-
        {
            "emailId": "Rani@gamil.com",
            "password": "Rani1234",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "America",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }

        Output :-
        {
            "userId": 4,
            "emailId": "Rani@gamil.com",
            "password": "\***\*\*\*\*\*\*\***",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "America",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }

### Delete User
    6. http://localhost:8082/api/user/4 ( Delete )

    result:- user deleted

---
---


# Post API Endpoints

### Get A Perticular Post
    1 http://localhost:8082/api/post/1 ( GET )

    result :-
    {
        "postId": 1,
        "postTitle": "iam here ",
        "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomized words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
        "postCategory": "god",
        "likeUserId": [],
        "postThumbnail": "post-cover.png",
        "date": "2024-07-20T07:52:28.116+00:00",
        "catId": 2,
        "userId": 2,
        "category": {
            "catId": 2,
            "catTitle": "Believe",
            "catDescription": "happy happy to you and now iam happy with you backoff"
        },
        "user": {
            "userId": 2,
            "emailId": "Raju@gamil.com",
            "password": "****\*\*\*\*****",
            "userName": "Raju",
            "userGender": "Male",
            "userNationality": "Indian",
            "userBio": "i am here to express myself or my views on raju's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }
    }

### Add new post
    2. http://localhost:8082/api/post ( POST )
    input :-
    {
        "postTitle": "iam here for you ",
        "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomized words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the",
        "postCategory": "god",
        "postThumbnail": "post-cover.png",
        "catId": 1,
        "userId": 4
    }

    Output :-
    {
        "postId": 2,
        "postTitle": "iam here for you ",
        "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomized words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the",
        "postCategory": "god",
        "likeUserId": [],
        "postThumbnail": "post-cover.png",
        "date": "2024-07-20T11:28:31.744+00:00",
        "catId": null,
        "userId": null,
        "category": {
            "catId": 1,
            "catTitle": "God",
            "catDescription": "a never pride of this things"
        },
        "user": {
            "userId": 4,
            "emailId": "Rani@gamil.com",
            "password": "****\*\*\*\*****",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "America",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }
    }

### Get all posts
    3. http://localhost:8082/api/post ( GET )

    Result :-
    [
        {
            "postId": 1,
            "postTitle": "iam here ",
            "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomized words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
            "postCategory": "god",
            "likeUserId": [],
            "postThumbnail": "post-cover.png",
            "date": "2024-07-20T07:52:28.116+00:00",
            "catId": 2,
            "userId": 2,
            "category": {
                "catId": 2,
                "catTitle": "Believe",
                "catDescription": "happy happy to you and now iam happy with you backoff"
            },
            "user": {
                "userId": 2,
                "emailId": "Raju@gamil.com",
                "password": "****\*\*\*\*****",
                "userName": "Raju",
                "userGender": "Male",
                "userNationality": "Indian",
                "userBio": "i am here to express myself or my views on raju's point of view",
                "userProfilePic": "default.png",
                "userCoverPicture": "default-cover.png"
            }
        },
        {
        "postId": 2,
        "postTitle": "iam here for you ",
        "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomized words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the",
        "postCategory": "god",
        "likeUserId": [],
        "postThumbnail": "post-cover.png",
        "date": "2024-07-20T11:28:31.744+00:00",
        "catId": 1,
        "userId": 4,
        "category": {
            "catId": 1,
            "catTitle": "God",
            "catDescription": "a never pride of this things"
        },
        "user": {
            "userId": 4,
            "emailId": "Rani@gamil.com",
            "password": "****\*\*\*\*****",
            "userName": "rani",
            "userGender": "Female",
            "userNationality": "America",
            "userBio": "i am here to express myself or my views on Rani's point of view",
            "userProfilePic": "default.png",
            "userCoverPicture": "default-cover.png"
        }
        }
    ]

### Delete a perticular Post
    4. http://localhost:8082/api/post ( DELETE )

        Result :- post delete successfully

### Get all post of a perticular user
    5. http://localhost:8082/api/post/userId/2 ( GET )

    result :
    [
        {
            "postId" :1,
            "postTitle": "iam here ",
            ": "There are many variations of passages of Lorem Ipsum available, but the alteration in some form, by injected humour, or words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
            "postCategory": "god",
            "likeUserId": null,
            "postThumbnail": "post-cover.png",
            "date": "2024-07-20T07:52:28.116+00:00",
            "catId": null,
            "userId": null,
            "category": {
                "catId": 2,
                "catTitle": "Believe",
                "catDescription": "happy happy to you and now iam happy with you fuckOff"
            },
            "user": {
                "userId": 2,
                "emailId": "Raju@gamil.com",
                "password": "************",
                "userName": "Raju",
                "userGender": "Male",
                "userNationality": "Indian",
                "userBio": "i am here to express myself or my views on raju's point of view",
                "userProfilePic": "default.png",
                "userCoverPicture": "default-cover.png"
            }
        }
    ]

### Get all posts according to a category

    6. http://localhost:8082/api/post/catId/2 ( GET )

    [
        {
            "postId": 1,
            "postTitle": "iam here ",
            "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
            "postCategory": "god",
            "likeUserId": null,
            "postThumbnail": "post-cover.png",
            "date": "2024-07-20T07:52:28.116+00:00",
            "catId": null,
            "userId": null,
            "category": {
                "catId": 2,
                "catTitle": "Believe",
                "catDescription": "happy happy to you and now iam happy with you fuckOff"
            },
            "user": {
                "userId": 2,
                "emailId": "Raju@gamil.com",
                "password": "************",
                "userName": "Raju",
                "userGender": "Male",
                "userNationality": "Indian",
                "userBio": "i am here to express myself or my views on raju's point of view",
                "userProfilePic": "default.png",
                "userCoverPicture": "default-cover.png"
            }
        }
    ]

---
# Category API Endpoints

### Get all Categories
    1. http://localhost:8082/api/category ( GET )

    result :
        [
            {
                "catId": 1,
                "catTitle": "God",
                "catDescription": "a never pride of this things"
            },
            {
                "catId": 2,
                "catTitle": "Believe",
                "catDescription": "happy happy to you and now iam happy with you "
            }
        ]

### get a perticular category according to category id

    - 2. http://localhost:8082/api/category/1 ( GET )

    result :
        {
            "catId": 1,
            "catTitle": "God",
            "catDescription": "a never pride of this things"
        }

### Create a new category

    3. http://localhost:8082/api/category ( POST )

    input :
    {
        "catTitle": "Books",
        "catDescription": "a never pride of this things read read read"
    }

    output :
    {
        "catId": 3,
        "catTitle": "Books",
        "catDescription": "a never pride of this things read read read"
    }

### Delete a perticular category 
    4. http://localhost:8082/api/category/1 ( DELETE )

        result :- Category delete successfully

------------------------

# Comment API Endpoints
### Get all comments
    1. http://localhost:8082/api/comment ( GET )

    output
    [
        {
            "commentId": 3,
            "commentContent": "your content is very ",
            "commentDate": "2024-07-20T10:57:21.410+00:00",
            "userId": 2,
            "postId": null,
            "post": {
                "postId": 1,
                "postTitle": "iam here ",
                "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or  words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
                "postCategory": "god",
                "likeUserId": [],
                "postThumbnail": "post-cover.png",
                "date": "2024-07-20T07:52:28.116+00:00",
                "catId": null,
                "userId": null,
                "category": {
                    "catId": 2,
                    "catTitle": "Believe",
                    "catDescription": "happy happy to you and now iam happy with you "
                },
                "user": {
                    "userId": 2,
                    "emailId": "Raju@gamil.com",
                    "password": "************",
                    "userName": "Raju",
                    "userGender": "Male",
                    "userNationality": "Indian",
                    "userBio": "i am here to express myself or my views on raju's point of view",
                    "userProfilePic": "default.png",
                    "userCoverPicture": "default-cover.png"
                }
            }
        }
    ]

### get a comment according to comment id
    2. http://localhost:8082/api/comment/3 ( GET )

        output :- display one comment according to comment id

### Delete a comment according to comment id
    3. http://localhost:8082/api/comment/3 ( DELETE )

        output :- Comment delete successfully

### Update Comment
    3. http://localhost:8082/api/comment/3 ( PUT )

        input 
        {
            "commentContent": "your content is very sweet"
        }

        output :- 
        {
            "commentId": 3,
            "commentContent": "your content is very sweet",
            "commentDate": "2024-07-20T10:57:21.410+00:00",
            "userId": 2,
            "postId": null,
            "post": {
                "postId": 1,
                "postTitle": "iam here ",
                "postDescription": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or  words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the ",
                "postCategory": "god",
                "likeUserId": [],
                "postThumbnail": "post-cover.png",
                "date": "2024-07-20T07:52:28.116+00:00",
                "catId": null,
                "userId": null,
                "category": {
                    "catId": 2,
                    "catTitle": "Believe",
                    "catDescription": "happy happy to you and now iam happy with you "
                },
                "user": {
                    "userId": 2,
                    "emailId": "Raju@gamil.com",
                    "password": "************",
                    "userName": "Raju",
                    "userGender": "Male",
                    "userNationality": "Indian",
                    "userBio": "i am here to express myself or my views on raju's point of view",
                    "userProfilePic": "default.png",
                    "userCoverPicture": "default-cover.png"
                }
            }
        }
