		.text
		.globl main
main:
	li $v0,5	#input int code
	syscall 	#input integer
	move $t0,$v0
	sw $t0,Main_main_int_num
	lw $t1,Main_main_int_num
	li $v0,1
	la $a0,0($t1)
	syscall 	#print integer
	li $v0,8	#input string code
	la $a0,BUFFER
	la $a1,30
	syscall 	#input string
	la $t1,BUFFER
	li $t2,1
	lw $t4,BUFFER_LEN
STR_EXTRACT_loop0:
	lb $t3,BUFFER($t4)
	sb $t3,Main_main_str($t4)
	sub $t4,$t4,$t2
	bgez $t4,STR_EXTRACT_loop0
	li $v0,4
	la $a0,Main_main_str
	syscall 	#print string
	li $t1,1
	lw $t4,0
STR_EXTRACT_loop1:
	lb $t3,($t4)
	sb $t3,Main_main_str2($t4)
	sub $t4,$t4,$t1
	bgez $t4,STR_EXTRACT_loop1
	li $v0,4
	la $a0,Main_main_str2
	syscall 	#print string
	li $t3,1
	lw $t5,CONSTANT1
STR_EXTRACT_loop2:
	lb $t4,CONSTANT0($t5)
	sb $t4,Main_main_str($t5)
	sub $t5,$t5,$t3
	bgez $t5,STR_EXTRACT_loop2
	li $v0,4
	la $a0,Main_main_str
	syscall 	#print string
	li $v0,4
	la $a0,CONSTANT2
	syscall 	#print string
		.data
nl: .asciiz"\n"
BUFFER: .space 30
BUFFER_LEN: .word 30
NEW_LINE: .asciiz "\n"
Main_main_int_num: .word 0
Main_main_str: .space 30 
Main_main_str2: .space 30 
CONSTANT0: .asciiz "An Str"
CONSTANT1: .word 6
CONSTANT2: .asciiz "Tab\t"
