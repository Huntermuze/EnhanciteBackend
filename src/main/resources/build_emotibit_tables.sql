# CREATE TABLE Clinician (
#                            ID INT AUTO_INCREMENT PRIMARY KEY,
#                            FirstName VARCHAR(255),
#                            LastName VARCHAR(255),
#                            Email VARCHAR(255),
#                            Password VARCHAR(255),
#                            ClinicName VARCHAR(255)
# );
#
# CREATE TABLE Patient (
#                          ID INT AUTO_INCREMENT PRIMARY KEY,
#                          FirstName VARCHAR(255),
#                          LastName VARCHAR(255),
#                          Email VARCHAR(255),
#                          Password VARCHAR(255),
#                          ClinicianID INT,
#                          EmotibitID INT,
#                          FOREIGN KEY (ClinicianID) REFERENCES Clinician(ID)
# );

# DROP TABLE Patient;
# DROP TABLE Clinician;
SELECT * FROM heart_rate;
SELECT * FROM temperature;
DELETE FROM heart_rate;
DELETE FROM temperature;
INSERT INTO heart_rate (PatientID, Value, date_time_recorded) VALUES (1, 60.3, '2019-04-01 12:00:00');
INSERT INTO heart_rate (PatientID, Value, date_time_recorded) VALUES (1, 60.3, '2019-07-01 12:00:00');
INSERT INTO temperature (PatientID, Value, date_time_recorded) VALUES (1, 98.6, '2019-04-01 12:00:00');
INSERT INTO temperature (PatientID, Value, date_time_recorded) VALUES (1, 98.6, '2019-05-22 12:00:00');