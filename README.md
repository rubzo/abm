ABM - Android BenchMarks
========================

Fork this project to receive a basic harness for Android benchmarking.
Check the examples package to see the Fibonacci example.

####To make your own benchmark:

 * Make your benchmark class implement the ABM interface.

    Implement prepare() with your non-timed setup code.

    Implement run() with your timed benchmark code.

    Implement verify() with non-timed verification code. 

 * Edit ABMAsyncTask.doInBackground()'s first line to instantiate your benchmark class.

 * Install the APK, and hit 'Start Benchmark' to run your benchmark.

 * Execution time will be reported on the screen, and output to the ABM tag in logcat, for easy script scraping. If verify() returns false, this will also be announced.
