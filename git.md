## git 계정 설정시 최초 1회

- `git config --global user.email '[내 github email]'`

- - 내 로컬 컴퓨터 전역에 github email 설정
  - `git config --global user.email`
- `git config --global user.name'[내 github username]'`
  - 내 로컬 컴퓨터 전역에 github name 설정
  - `git config --global user.name`



## git으로  폴더를 앞으로 관리할 때 최초 1회

- `git init` : git 시작하기, 이 특정 폴더를 git으로 관리할거야!

- `git remote add origin [github repo 주소]` : 
  - remote 등록
  - 레포지토리 이름 등록

- `git remote -v`



## git으로 작업할 때

- `git status` : git으로 관리되고 있는 폴더의 현황 조회

- `git add` : git 에게 traking을 요청

  - staging area 에 올려줘!

    1. `git add[파일이름1.확장자]`

    2. `git add[파일이름1.확장자] [파일이름2.확장자]`

       ​	띄어쓰기가 포함된 파일이다 -> `'`따옴표로 감싸준다`'`

    3. `git add .` : 전체를 다 올려줘

- `git commit -m '[커밋 메시지]'` :
  - staging agrea에 올린 컨텐츠에 커밋 메시지 남기기
  - 커밋 메시지
    - 명령조로 작성한다.



- ` $ git push origin master` : github에 파일 모두 올리기
  - origin : 로컬 폴더에서 깃헙 레포로 보낼 때 통로의 별명(branch)
  - master : origin 통로의 이름(main)
- `$ git clone [나의 github repo 주소]` : (주소 끝에는 .git 붙여야함)
  - 폴더를 만들지 않고도 바로 내려받을 수 있다.
  - A가 A꺼를 clone 받았다 -> `add` `commit` `push`
  - B가 A꺼를 clone 받았다 -> `pull request` 활용하여 요청가능 == B의 코드를 A의 레포에 반영하고 싶을 때