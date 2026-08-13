CREATE TABLE [users] (
  [id] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL,
  [last_name] varchar(100),
  [email] varchar(254) UNIQUE NOT NULL,
  [password_hash] varchar(255) NOT NULL,
  [birth_date] date NOT NULL,
  [created_at] datetime2 DEFAULT (sysdatetime())
)
GO

CREATE TABLE [recurrence] (
  [id] uuid PRIMARY KEY,
  [day_of_month] tinyint,
  [days_of_week] tinyint,
  [week_of_month] tinyint,
  [months_of_year] smallint NOT NULL
)
GO

CREATE TABLE [status_of_routines] (
  [id] tinyint PRIMARY KEY IDENTITY(1, 1),
  [name] varchar(50) NOT NULL
)
GO

CREATE TABLE [routines] (
  [id] uuid PRIMARY KEY,
  [name] varchar(100),
  [description] varchar(255),
  [created_at] datetime2 DEFAULT (sysdatetime()),
  [start_at] datetime2,
  [recurrence_id] uuid UNIQUE NOT NULL,
  [user_id] uuid NOT NULL,
  [goal_id] uuid,
  [status_of_routines_id] tinyint NOT NULL
)
GO

CREATE TABLE [status_of_goals] (
  [id] tinyint PRIMARY KEY IDENTITY(1, 1),
  [name] varchar(50) NOT NULL
)
GO

CREATE TABLE [goals] (
  [id] uuid PRIMARY KEY,
  [name] varchar(100) NOT NULL,
  [description] varchar(255),
  [progress] decimal(5,2) NOT NULL CHECK (progress between 0 and 100) DEFAULT (0),
  [created_at] datetime2 DEFAULT (sysdatetime()),
  [to_finish_at] date,
  [finished_at] date,
  [status_id] tinyint NOT NULL DEFAULT (1),
  [user_id] uuid NOT NULL
)
GO

CREATE TABLE [tasks] (
  [id] uuid PRIMARY KEY,
  [name] varchar(100) NOT NULL,
  [description] varchar(255),
  [allows_multiple_completions] bit NOT NULL DEFAULT (1),
  [created_at] datetime2 NOT NULL DEFAULT (sysdatetime()),
  [user_id] uuid NOT NULL,
  [goal_id] uuid,
  [routine_id] uuid
)
GO

CREATE TABLE [task_history] (
  [id] uuid PRIMARY KEY,
  [scheduled_for] date NOT NULL,
  [completed_at] datetime2 NOT NULL DEFAULT (sysdatetime()),
  [task_id] uuid NOT NULL
)
GO

ALTER TABLE [status_of_goals] ADD FOREIGN KEY ([id]) REFERENCES [goals] ([status_id])
GO

ALTER TABLE [routines] ADD FOREIGN KEY ([recurrence_id]) REFERENCES [recurrence] ([id])
GO

ALTER TABLE [routines] ADD FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
GO

ALTER TABLE [goals] ADD FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
GO

ALTER TABLE [tasks] ADD FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
GO

ALTER TABLE [routines] ADD FOREIGN KEY ([goal_id]) REFERENCES [goals] ([id])
GO

ALTER TABLE [tasks] ADD FOREIGN KEY ([goal_id]) REFERENCES [goals] ([id])
GO

ALTER TABLE [tasks] ADD FOREIGN KEY ([routine_id]) REFERENCES [routines] ([id])
GO

ALTER TABLE [routines] ADD FOREIGN KEY ([status_of_routines_id]) REFERENCES [status_of_routines] ([id])
GO

ALTER TABLE [task_history] ADD FOREIGN KEY ([task_id]) REFERENCES [tasks] ([id])
GO