import math

dividendo = '2445700'
divisor = '132'
numDividendoTemp = 0
numDivisor = float(divisor)
longitudDivisor = len(divisor)
longitudDividendo = len(dividendo)
longitudCociente = 0
dividendoTemp = ''
linea = ' '
lineaResultado = ''
lineaResiduo = ''

for number in divisor:
	linea += ' '
for number2 in dividendo:
	linea += '_'
linea += '_'


if(longitudDividendo > longitudDivisor):
	numDividendoTemp = float(dividendo[:longitudDivisor])
	if(numDividendoTemp > numDivisor):
		longitudCociente = longitudDivisor
		resultTemp = numDividendoTemp/numDivisor
	else:
		longitudCociente = longitudDivisor + 1
		numDividendoTemp = float(dividendo[:longitudDivisor+1])
		resultTemp = numDividendoTemp/numDivisor

	numeros = math.modf(resultTemp)
	decimales = numeros[0]
	entero = numeros[1]
	cocienteTemp = int(entero)

	print 'longitudCociente '+ str(longitudCociente*2)
	lineaResultado += (str(cocienteTemp)).rjust(((longitudCociente*2) - 1), '0')
	print 'linea: ' + lineaResultado

	if(decimales > 0):
		residuo =  numDividendoTemp % numDivisor
		lineaResiduo =  str(residuo)


print lineaResultado
print linea
print divisor + '|' + dividendo
print lineaResiduo