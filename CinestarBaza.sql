CREATE DATABASE [CinestarApp]
GO

USE CinestarApp

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Genre](
	[IDGenre] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[IDMovie] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](50) NULL,
	[Description] [nvarchar](2000) NULL,
	[Duration] [int] NULL,
	[StartingDate] [date] NULL,
	[Link] [nvarchar](100) NULL,
	[PicturePath] [nvarchar](100) NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MovieGenre](
	[IDMovieGenre] [int] IDENTITY(1,1) NOT NULL,
	[MovieID] [int] NULL,
	[GenreID] [int] NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MoviePerson](
	[IDMoviePerson] [int] IDENTITY(1,1) NOT NULL,
	[PersonID] [int] NULL,
	[MovieID] [int] NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[IDPerson] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Surname] [nvarchar](50) NULL,
	[PersonFunctionID] [int] NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PersonFunction](
	[IDPersonFunction] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[IDUser] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Username] [nvarchar](50) NULL,
	[Password] [nvarchar](200) NULL,
	[UserRoleID] [int] NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[IDUserRole] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[checkIfGenreExists]
	@Name NVARCHAR(50),
	@Id INT OUTPUT
AS 
BEGIN 
DECLARE @BrojZanra int
SELECT @BrojZanra =  COUNT(*)  FROM [CinestarApp].[dbo].[Genre]
WHERE Name = @Name 
IF(@BrojZanra = 1)
BEGIN
SELECT @Id = IDGenre FROM [CinestarApp].[dbo].[Genre]
WHERE Name = @Name 
END
ELSE
BEGIN
SET @Id = -1
END
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[checkIfMovieExists]
	@Title NVARCHAR(50),
	@Description NVARCHAR(2000),
	@Duration INT,
	@StartingDate DATE,
	@Link NVARCHAR(100),
	@PicturePath NVARCHAR(100),
	@Id INT OUTPUT
AS 
BEGIN 
DECLARE @BrojFimova int
SELECT @BrojFimova =  COUNT(*)  FROM [CinestarApp].[dbo].[Movie]
WHERE Title = @Title AND Description = @Description AND Duration =@Duration 
AND StartingDate =@StartingDate AND Link =@Link AND PicturePath = @PicturePath
IF(@BrojFimova = 1)
BEGIN
SELECT @Id = IdMovie FROM [CinestarApp].[dbo].[Movie]
WHERE Title = @Title AND Description = @Description AND Duration =@Duration 
AND StartingDate =@StartingDate AND Link =@Link AND PicturePath = @PicturePath
END
ELSE
BEGIN
SET @Id = -1
END
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[checkIfPersonExists]
	@Name NVARCHAR(50),
	@Surname NVARCHAR(200),
@PersonFunctionID NVARCHAR(200),
	@Id INT OUTPUT
AS 
BEGIN 
DECLARE @PersonsNumber int
SELECT @PersonsNumber =  COUNT(*)  FROM [CinestarApp].[dbo].[Person]
WHERE Name = @Name AND Surname = @Surname
IF(@PersonsNumber = 1)
BEGIN
SELECT @Id = IDPerson FROM [CinestarApp].[dbo].[Person]
WHERE Name = @Name AND Surname = @Surname
END
ELSE
BEGIN
SET @Id = -1
END
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[checkIfUserExists]
	@Username NVARCHAR(50),
	@Password NVARCHAR(200),
	@Id INT OUTPUT
AS 
BEGIN 
DECLARE @BrojKorisnika int
SELECT @BrojKorisnika =  COUNT(*)  FROM [CinestarApp].[dbo].[User]
WHERE Username = @Username AND Password = @Password
IF(@BrojKorisnika = 1)
BEGIN
SELECT @Id = IDUser FROM [CinestarApp].[dbo].[User]
WHERE Username = @Username AND Password = @Password
END
ELSE
BEGIN
SET @Id = -1
END
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[createGenre]
	@Name NVARCHAR(50),
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[Genre] VALUES(@Name)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createMovie]
	@Title NVARCHAR(50),
	@Description NVARCHAR(2000),
	@Duration INT,
	@StartingDate DATE,
	@Link NVARCHAR(100),
	@PicturePath NVARCHAR(100),
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[Movie] VALUES(@Title, @Description, @Duration, @StartingDate,@Link,@PicturePath)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[createMovieGenre]
	@GenreID NVARCHAR(50),
	@MovieID NVARCHAR(50),

	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[MovieGenre] VALUES(@MovieID,@GenreID)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[createMoviePerson]
	@PersonID NVARCHAR(50),
	@MovieID NVARCHAR(50),
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[MoviePerson] VALUES(@PersonID,@MovieID)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[createMoviePersonSetPF]
	@PersonID int,
	@MovieID int,
	@IdPersonFunction int
AS 
BEGIN 
UPDATE [CinestarApp].[dbo].[Person]
   SET [PersonFunctionID] = @IdPersonFunction 
   WHERE IDPerson = @PersonID
	INSERT INTO [CinestarApp].[dbo].[MoviePerson] VALUES(@PersonID,@MovieID)
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createPerson]
@Name NVARCHAR(50),
	@Surname NVARCHAR(200),
@PersonFunctionID int,
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[Person] VALUES(@Name, @Surname, @PersonFunctionID)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[createPersonFunction]
	@Name NVARCHAR(50),
	@Username NVARCHAR(50),
	@Password NVARCHAR(200),
	@UserRoleID INT,
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[User] VALUES(@Name, @Username, @Password, @UserRoleID)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[createUser]
	@Name NVARCHAR(50),
	@Username NVARCHAR(50),
	@Password NVARCHAR(200),
	@UserRoleID INT,
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO [CinestarApp].[dbo].[User] VALUES(@Name, @Username, @Password, @UserRoleID)
	SET @Id = SCOPE_IDENTITY()
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[deleteAllMoviesData]
AS 
BEGIN 
	DELETE FROM MovieGenre
	DELETE FROM MoviePerson
	DELETE FROM Person
	DELETE FROM Genre
	DELETE FROM Movie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteGenre]
	@IdGenre INT
AS 
BEGIN 
DELETE FROM  [CinestarApp].[dbo].[MovieGenre]
WHERE GenreID = @IdGenre
DELETE FROM [CinestarApp].[dbo].[Genre]
	WHERE IDGenre = @IdGenre
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deleteMovie]
	@IdMovie INT
AS 
BEGIN 
DELETE FROM [CinestarApp].[dbo].[Movie]
	WHERE IDMovie = @IdMovie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deleteMovieGenre]
@IdMovie int,
@IdGenre INT	 
AS 
BEGIN 
DELETE FROM MovieGenre
WHERE GenreID = @IdGenre AND MovieID = @IDMovie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deleteMoviePerson]
@IdMovie int,
	@IdPerson INT	 
AS 
BEGIN 
DELETE FROM MoviePerson
WHERE PersonID = @IdPerson AND MovieID = @IDMovie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deletePerson]
	@IdPerson INT	 
AS 
BEGIN 
DELETE FROM MoviePerson
WHERE PersonID = @IdPerson
	DELETE  
	FROM 
			Person
	WHERE 
		IDPerson = @IdPerson
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getActors]
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Person] as p
		WHERE  p.PersonFunctionID = 2
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getDirectors]
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Person] as p
		WHERE  p.PersonFunctionID = 1
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getGenre]
	@IdGenre INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Genre]
	WHERE 
		IDGenre = @IdGenre
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getGenres]
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Genre] 
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getMovie]
	@IdMovie INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Movie]
	WHERE 
		IDMovie = @IdMovie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getMovieActors]
@IdMovie int
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Person] as p
		inner join [CinestarApp].[dbo].[MoviePerson] as mp
		ON p.IDPerson = mp.PersonID
		WHERE mp.MovieID = @IdMovie AND p.PersonFunctionID = 2
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getMovieDirectors]
@IdMovie int
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Person] as p
		inner join [CinestarApp].[dbo].[MoviePerson] as mp
		ON p.IDPerson = mp.PersonID
		WHERE mp.MovieID = @IdMovie AND p.PersonFunctionID = 1
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getMovieGenres]
@IdMovie int
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Genre] as g
		inner join [CinestarApp].[dbo].[MovieGenre] as mg
		ON g.IDGenre = mg.GenreID
		WHERE mg.MovieID = @IdMovie
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getMovies]
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Movie]
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[getPerson]
	@IdPerson INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[Person]
	WHERE 
		IDPerson = @IdPerson
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getUser]
	@Username nvarchar(50),
	@Password nvarchar(200)
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[User]
	WHERE 
		Username = @Username and Password = @Password
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getUserById]
	@IdUser INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[User]
	WHERE 
		IDUser = @IdUser
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[getUsers]
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		[CinestarApp].[dbo].[User]
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[updateMovie]
	@IdMovie INT,
	@Title NVARCHAR(50),
	@Description NVARCHAR(2000),
	@Duration INT,
	@StartingDate DATE,
	@Link NVARCHAR(100),
	@PicturePath NVARCHAR(100)
AS 
BEGIN 
	UPDATE [CinestarApp].[dbo].[Movie]
   SET [Title] = @Title, 
     [Description] = @Description,
      [Duration] = @Duration, 
      [StartingDate] = @StartingDate,
      [Link] = @Link,
      [PicturePath] = @PicturePath
 WHERE IDMovie = @IdMovie
END
GO
