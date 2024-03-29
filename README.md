> 소개

HashMap과 ArrayList를 활용하여 만든 간단한 콘솔 게시판

> 설명

User
- String id
- String password

Post
- int number
- int pageNumber
- String id
- String title
- String text

UserManager
- join()
- login()
- logout()
- deleteUser()
- updatePassword()

PostManager
- posting()
- readPost()
- modifyPost()
- deletePost()

<br>

유저는 회원가입시 아이디와 비밀번호를 입력하여 가입한다.<br>
글 작성, 수정 등 글에 관련한 기능은 로그인 후 이용할 수 있다.<br>
새롭게 생성된 user 객체는 userManager를 통해 userlist에 저장하고 관리한다.<br>

post는 순서대로 글번호, 페이지번호, 작성자 id, 글 제목, 글 내용을 담은 객체이다.<br>
postManager를 통해 생성되고 Arraylist board에 hashMap<userId, post> 형태로 저장하게 된다.<br>

>Demo

<img src = "" width = 300>
