const validator = require('validator')
const chalk = require('chalk')

const notEmail = 'hello_Im_not_an_email.com'
const validEmail = 'juanjo.santos@juanjo.com'

console.log(validator.isEmail(notEmail))
console.log(validator.isEmail(validEmail))

console.log(chalk.green('Success NOW!'))

const redMessage = chalk.red('New Message!')

console.log(redMessage)

//Leer valores desde consola
//console.log(process.argv)

console.log(process.argv[2])
