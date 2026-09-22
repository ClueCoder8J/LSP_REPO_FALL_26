1. The solution consisted of one big class, with a few functions present
2. I created a couple extra classes and grouped more things into functions
3. I introduced a CSVManager class to manage file I/O, and a transformer class to handle data
4. The ETLPipeline was used to control the flow of data. File lines were retrieved via the CSVManager, and then the necessary info was sent to the Transformer
5. I believe the design is easier to read and debug.

I did not use AI

Internet Resources used:
- w3schools java tutorial → https://www.w3schools.com/java/java_class_methods.asp
