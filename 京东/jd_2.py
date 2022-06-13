import numpy
for x in range(1000):
    for y in range(1000):
        if(numpy.gcd(x,y)==60 and numpy.lcm(x,y)==720):
            print(x,y,x+y)