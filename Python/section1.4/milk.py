"""
ID: jameszh1
LANG: PYTHON2
TASK: milk
"""
from operator import itemgetter

fin = open ('milk.in', 'r')
fout = open ('milk.out', 'w')
milk_demand, farmer_num = map(int, fin.readline().split())
farmer_milk_list = list()

for i in range(farmer_num):
    line = fin.readline().strip()
    temp = line.split(" ")
    price = int(temp[0])
    amount = int(temp[1])
    farmer_milk_list.append((price, amount))

farmer_milk_list = sorted(farmer_milk_list, key=itemgetter(0), reverse=False)
total_price = 0
total_milk = 0

for (price, amount) in farmer_milk_list:
    if (total_milk + amount >= milk_demand):
        total_price = total_price + (milk_demand - total_milk) * price
        break
    else:
        total_price = total_price + amount * price
        total_milk = total_milk + amount
fout.write(str(total_price) + '\n')
fout.close()