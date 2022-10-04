<!-- -->
# 헬스케어 (디자인패턴)
- Language : Java
- Tools : Apache NetBeans IDE 
- Database : Mysql
- 형성관리 : Smartgit
### 사용자 
- 관리자 : 회원가입 관리 (회원 정보 추가, 삭제, 수정), 운동 구성 관리 (추가, 삭제, 수정)
- 트레이너 : 회원 정보 조회, 운동 구성 및 회원 식단 설정, 회원에게 공지사항 알림 제공
-  회원 : 인바디 정보 (날짜, 키, 몸무게, BMI), 운동 목표 입력, 트레이너 추천 운동 구성 및 식단 조회, 운동 달성 체크
### 주요기능
![헬스케어 특징 목록](https://user-images.githubusercontent.com/71927210/128536326-9beff814-1c4a-4895-8fb8-8290b317df70.PNG)

### 관련기술
![관련기술](https://user-images.githubusercontent.com/71927210/128536488-9805b0a2-bc1a-4d10-96f2-00cb2e7c80ad.PNG)

### 이해 당사자 요구사항
![image](https://user-images.githubusercontent.com/71927210/128537141-299dca98-248f-497b-87fb-8460bd73a0f8.png)

### 유스케이스
#### 1.관리자
![image](https://user-images.githubusercontent.com/71927210/128537414-2e442ce1-60e3-4609-b3d7-626eec287b94.png)
#### 2.로그인
![image](https://user-images.githubusercontent.com/71927210/128537617-85c02ee3-8c11-4f75-8a97-e6d6f616f03e.png)
#### 3.회원정보 입력
![image](https://user-images.githubusercontent.com/71927210/128537928-13684d76-cb85-4c2c-9df6-1ef2518427b2.png)
#### 4.공지사항
![image](https://user-images.githubusercontent.com/71927210/128538251-ed142c04-649b-496d-b06a-f9d13d2530ba.png)
#### 5.운동 구성 재설정
![image](https://user-images.githubusercontent.com/71927210/128538286-822de9df-6377-4b10-bda2-8d7e708fb986.png)
#### 6. 운동 체크
![image](https://user-images.githubusercontent.com/71927210/128538348-7eb2c3b9-1762-4333-b7f0-b5885e096eab.png)
#### 7.회원 식단 구성
![image](https://user-images.githubusercontent.com/71927210/128538379-6816eb94-48e6-4735-b6a1-5c2377db2649.png)

### 설계 및 구현
#### 스트래티지 패턴 적용
![스트래티지](https://user-images.githubusercontent.com/71927210/129739320-80f2844d-bb0b-4077-88f5-027f30181c8b.png)
#### 옵저버 패턴 적용
![옵저버](https://user-images.githubusercontent.com/71927210/129739416-d5de2b5e-8e84-4ece-9cc9-43e22bda1245.png)
![옵저버2](https://user-images.githubusercontent.com/71927210/129739536-3615eb40-8f66-46ba-babd-83702f4a10aa.png)

#### 데코레이터 패턴 적용
![데코레이터](https://user-images.githubusercontent.com/71927210/129739506-8024e211-3f97-4bdb-b03a-ecb30e666cc2.png)
#### 템플릿 메서드 패턴 적용
![템플릿](https://user-images.githubusercontent.com/71927210/129739618-cddb9a02-fe49-4a2c-9f0d-e13f4e58e079.png)
#### 커맨드 패턴 적용
![커맨드](https://user-images.githubusercontent.com/71927210/129739668-9bfe1228-b221-4bf2-9871-d65b11e3033b.png)

### 일정 계획 평가
![image](https://user-images.githubusercontent.com/71927210/128538804-9eab7b7c-83b3-404f-b45d-8fe7c81e6050.png)
