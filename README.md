## The circular map is the file random_1.png or the file /genome1/random_1.png

## How to run the code
Sadly, I have not tried running it with the command line. I used VS Code to run it.

Just open the whole folder in VSCode, and run the file app.java in the folder /genome1/src/main/java/genome1. You will see a file called random_1.png locating in the folder /genome1. That file is the genome circular map.

If you want to change the genbank file, then make changes to the file genome.db which locates in the folder /genome1.

## How I got my solution
I panicked at the first time I saw this challenge. I did not know anything about biology before. I searched for some key terms like genbank, circular map, ... Then I found a tool online to convert from gb file to circular map. This is the tool: http://cgview.ca/. After getting the map, I found that the map displayed only the features. So I decided to write a program that would do the same thing.

Then things became easier. I found a library (api) to help me with writing the code. This is the library: https://github.com/paulstothard/cgview. I just used that library to write a simple code that generates the desired map.

## My thoughts
This is a very hard challenge if we have to understand everything from the genbank file to the circular map. I would try to do so if I have more time. However, I have only 3 days, so I decided to understand just enough. The folder that I uploaded is not complete. It will run fine for common cases, including the genome.gb that you gave us. However, it will not run well when we try some other gb files, for example, this one: https://www.ncbi.nlm.nih.gov/Sitemap/samplerecord.html#:~:text=For%20example%2C%20for%20GenBank%20records,is%20just%20the%20accession%20number. The image should contain only 3 features, but I got 4.
