"""
ID: jameszh1
LANG: PYTHON2
TASK: milk2
"""
from operator import itemgetter
fin = open ('milk2.in', 'r')
fout = open ('milk2.out', 'w')
number = int(fin.readline().strip())
time_dict = list()
for i in range(number):
    line = fin.readline().strip().split(" ")
    start_time =int(line[0])
    end_time = int(line[1])
    t = (start_time, end_time)
    time_dict.append(t)
time_dict = sorted(time_dict, key=itemgetter(0))
start, end = time_dict[0][0], time_dict[0][1]
milk_time, not_milk_time = end  - start, 0
for i in range(1, len(time_dict)):
    if (time_dict[i][0] > end):
        not_milk_time = max(time_dict[i][0] - end, not_milk_time)
        start = time_dict[i][0]
        end = time_dict[i][1]
    elif (time_dict[i][0] <= end):
        milk_time = max(time_dict[i][1] - start, milk_time)
        end = max(end, time_dict[i][1])


fout.write (str(milk_time) + " " + str(not_milk_time) + '\n')
fout.close()