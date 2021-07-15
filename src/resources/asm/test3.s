		.text
		.globl main
main:
	lw $t0,Main_main_arr
	li $t1,1
	li $t2,0
	mul $t2,$t2,4
	add $t0,$t0,$t2
	sw $t1,($t0)
	lw $t0,Main_main_arr
	li $t1,0
	mul $t1,$t1,4
	add $t0,$t1,$t0
	lw $t0,($t0)
	li $v0,1
	la $a0,0($t0)
	syscall 	#print integer
		.data
nl: .asciiz"\n"
BUFFER: .space 30
BUFFER_LEN: .word 30
NEW_LINE: .asciiz "\n"
Main_main_arr: .word 0
Main_main_arr_size: .word 0
