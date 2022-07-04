#955 Robot CSV data viewer

reads and makes graphs from WPILib generated CSVs - https://docs.wpilib.org/en/stable/docs/software/telemetry/datalog.html

Dependencies:
 - `matplotlib`
 - `pandas`
 - `tkinter`

Usage:
 - Rename csv log from robot to `data.csv` and place it in the same directory as the `RobotDataViewer.py`
 - Make sure the csv has at least 1 column labeled `time`
 - Run the script
 - Check the data that should be displayed on the graph
 - Click `Open Graph` to display the data in matplotlib