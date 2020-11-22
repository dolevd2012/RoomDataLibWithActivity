# RoomDataLib
[![](https://jitpack.io/v/dolevd2012/RoomDataLib.svg)](https://jitpack.io/#dolevd2012/RoomDataLib)
![](https://img.shields.io/github/license/dolevd2012/RoomDataLib?color=blue)
![](https://img.shields.io/github/issues/dolevd2012/RoomDataLib?color=purple)
# Database Columns

![readme md](https://user-images.githubusercontent.com/74798510/99882821-da24e900-2c2b-11eb-8632-d46deb37b8d3.png)

## Requirement 
```minSdkVersion 23```



## Repository
Add this in your root build.gradle file (not your module build.gradle file):
```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency
Add this to your module's build.gradle file (Note: version should match the jitpack badge above)
```
dependencies {
	implementation 'com.github.dolevd2012:RoomDataLibWithActivity:1.00.01'
}
```
## Usage
Get the instance of RoomData:
```
RoomDB database;
database = RoomDB.getInstance(this);
```
## Creating class + adding attributes
```
MainData data = new MainData();
data.setString("Any String you want"); 
```
Default value is empty String

```
MainData data = new MainData();
data.setNumber("Any int you want"); 
```
Default value is -1

```
MainData data = new MainData();
data.setID("Any int you want"); 
```
i do not recommend doing that because you may 
override another MainData in your database

## Adding the MainData to the database
```
database.mainDao().insert(data);
```
# Queries we can use 
![Untitled md](https://user-images.githubusercontent.com/74798510/99883354-8e743e80-2c2f-11eb-9274-f0e6975da25a.png)
