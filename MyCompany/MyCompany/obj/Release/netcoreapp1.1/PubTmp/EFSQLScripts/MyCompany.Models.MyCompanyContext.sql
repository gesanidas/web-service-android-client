IF OBJECT_ID(N'__EFMigrationsHistory') IS NULL
BEGIN
    CREATE TABLE [__EFMigrationsHistory] (
        [MigrationId] nvarchar(150) NOT NULL,
        [ProductVersion] nvarchar(32) NOT NULL,
        CONSTRAINT [PK___EFMigrationsHistory] PRIMARY KEY ([MigrationId])
    );
END;

GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20170407163211_Initial')
BEGIN
    CREATE TABLE [Employee] (
        [ID] int NOT NULL IDENTITY,
        [Email] nvarchar(max),
        [Name] nvarchar(max),
        [Password] nvarchar(max),
        [Phone] int NOT NULL,
        [Title] nvarchar(max),
        CONSTRAINT [PK_Employee] PRIMARY KEY ([ID])
    );
END;

GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20170407163211_Initial')
BEGIN
    INSERT INTO [__EFMigrationsHistory] ([MigrationId], [ProductVersion])
    VALUES (N'20170407163211_Initial', N'1.1.1');
END;

GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20170408163805_InitialCreate')
BEGIN
    CREATE TABLE [Skill] (
        [SkillID] int NOT NULL IDENTITY,
        [Description] nvarchar(max),
        [EmployeeID] int NOT NULL,
        CONSTRAINT [PK_Skill] PRIMARY KEY ([SkillID]),
        CONSTRAINT [FK_Skill_Employee_EmployeeID] FOREIGN KEY ([EmployeeID]) REFERENCES [Employee] ([ID]) ON DELETE CASCADE
    );
END;

GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20170408163805_InitialCreate')
BEGIN
    CREATE INDEX [IX_Skill_EmployeeID] ON [Skill] ([EmployeeID]);
END;

GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20170408163805_InitialCreate')
BEGIN
    INSERT INTO [__EFMigrationsHistory] ([MigrationId], [ProductVersion])
    VALUES (N'20170408163805_InitialCreate', N'1.1.1');
END;

GO

