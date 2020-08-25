from functools import reduce

def convert_timestamp_to_seg(h,m,s):		
	return abs(h)*3600+ abs(m)*60 + abs(s)

def convert_seg_to_timestamp(s):
	return abs(s) // 3600,(abs(s)%3600)//60,(abs(s)%3600)%60

def triangular_numbers(n):
    return list(map(lambda x:(x*(x-1))//2,list(range(2,n+2))))

def even_numbers_between(a,b):
    return list(range(a+a%2,b+1,2))

def factorial(n):
    return reduce(lambda x,y:x*y,[1]+list(range(1,n+1)))