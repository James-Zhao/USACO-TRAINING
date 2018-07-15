"""
ID: jameszh1
LANG: PYTHON2
TASK: friday
"""
def is_leap_year(year):
    if ((year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)):
        return True
    else:
        return False

def computeDaysOfMonth(month, year):
    if month in (4, 6, 9, 11):
        return 30
    if month == 2:
        if (is_leap_year(year)):
            return 29
        else:
            return 28
    return 31

INITIAL_YEAR = 1900
MONTH_NUM = 12
fin = open ('friday.in', 'r')
fout = open ('friday.out', 'w')
years = int(fin.readline().strip())
day_list = [0, 0, 0, 0, 0, 0, 0]
total_days = 0
for i in range(years):
    current_year = INITIAL_YEAR + i
    for j in range(1, MONTH_NUM + 1, 1):
        day_list[(total_days + 13) % 7] = day_list[(total_days + 13) % 7] + 1
        days_of_month = computeDaysOfMonth(j, current_year)
        total_days = total_days + days_of_month

fout.write (str(day_list[6]) + " " + str(day_list[0]) + " " + str(day_list[1]) + " " + str(day_list[2]) + " " + str(day_list[3]) + " " + str(day_list[4]) + " " + str(day_list[5]) + '\n')
fout.close()