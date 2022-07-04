import matplotlib.pyplot as plt
import pandas as pd
import tkinter as tk

df = pd.read_csv('data.csv')
window = tk.Tk()

selected_cols = []

def show_graph():
    for graph in selected_cols:
        if graph.get() == 1:
            plt.plot(df['time'],df[str(graph)], label=str(graph))
            
    plt.title("Robot Data")
    plt.xlabel("Time")
    plt.legend()
    plt.show()

for col in df.columns:
    if col != 'time':
        var = tk.IntVar(name=col)
        c1 = tk.Checkbutton(window, text=col, variable=var)
        c1.pack()
        selected_cols.append(var)


b1 = tk.Button(window, text='Open Graph', command=show_graph)
b1.pack()
window.mainloop()
