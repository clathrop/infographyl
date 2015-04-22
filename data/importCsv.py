#!/usr/bin/python
import csv
import MySQLdb
import os

mydb = MySQLdb.connect(host='localhost',
user='iguser',
passwd='igpass',
db='infographyl_db')

cursor = mydb.cursor()

csv_data = csv.reader(file('infographyl_db_export.csv'), delimiter='|')

start_row = 0

def getSize(fileobject):
	fileobject.seek(0,2) # move the cursor to the end of the file
	size = fileobject.tell()
	return size

file = open('infographyl_db_export.csv', 'rb')
curr_file_size = getSize(file)

# Get the last file Size
if os.path.exists("file_size"):
	print("file_size exists")
	with open("file_size") as f:
		saved_file_size = int(f.read())


# Get the last processed line
if os.path.exists("lastline"):
	with open("lastline") as f:
		start_row = int(f.read())


if curr_file_size < saved_file_size: start_row = 0

cur_row = 0
for row in csv_data:
	if cur_row >= start_row:
		cursor.execute("INSERT INTO infographics (name,description,url,category,tags) VALUES (%s,%s,%s,%s,%s)", (row[0],row[1],row[2],row[3],row[4]))
		#cursor.execute("LOAD DATA INFILE '/data/infographyl_db.csv' INTO TABLE infographics_test FIELDS TERMINATED BY ',' ENCLOSED BY '\"' (name,description,url,category,tags) ")
    	# Other processing if necessary
		cur_row += 1

mydb.commit()
cursor.close()


# Store the last processed line
with open("lastline", 'w') as f:
	start_line = f.write(str(cur_row + 1)) # you want to start at the **next** line
                                      # next time
# Store Current  File Size To Find File Flush    
with open("file_size", 'w') as f:
	start_line = f.write(str(curr_file_size))

# not necessary but good for debug
print (str(cur_row))


print "Done"