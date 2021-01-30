## How to run the code
There is a file call CgviewTest0.java inside the folder api_example. You can run that code, and it will create a .png file called random_1.png outside the folder api_example. If you need to change the gb file (you should not, because you have to modified the code a little bit to make sure it runs fine), you can change the genome.gb file outside the folder api_example.

## My thoughts
This is a very hard challenge if we have to understand everything from the genbank file to the circular map. I would try to do so if I have more time. However, I have only 3 days, and the folder uploaded is the best that I got.
The folder that I uploaded is not complete. It will run fine for common cases, including the genome.gb that you gave us. However, it will not run well when we try some other gb files, for exmaple, this one : https://www.ncbi.nlm.nih.gov/Sitemap/samplerecord.html#:~:text=For%20example%2C%20for%20GenBank%20records,is%20just%20the%20accession%20number. 
The image should contain only 3 features, but I got 4.

## How I got my solution
I panicked at the first time I saw this challenge. I did not know any thing about biology before. I searched for some key terms like genbank, circular map , ... Then I found a tool online to convert from gb file to circular map. This is the tool : http://cgview.ca/ . After getting the map, I found that the map displayed only the features. So i decided to write a program that would do the same thing.

Then things became easier. I found a library (api) to help me with writing the code. This is the library : https://github.com/paulstothard/cgview . I just used that library to write a simple code that generate the desired map

