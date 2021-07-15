		.text
		.globl main
main:
	li $t0,10
	sw $t0,Main_main_arr1_size	#store size
	mul $t0,$t0,4
	li $v0,9	#allocate
	move $a0,$t0	#set size
	syscall 
	sw $v0,Main_main_arr1	#store address
	lw $t0,Main_main_arr1
	li $t1,3
	li $t2,0
	mul $t2,$t2,4
	add $t0,$t0,$t2
	sw $t1,($t0)
	lw $t0,Main_main_arr1
	li $t1,6
	li $t2,5
	mul $t2,$t2,4
	add $t0,$t0,$t2
	sw $t1,($t0)
	lw $t0,Main_main_arr1
	li $t1,5
	mul $t1,$t1,4
	add $t0,$t1,$t0
	lw $t0,($t0)
	li $v0,1
	la $a0,0($t0)
	syscall 	#print integer
	lw $t0,Main_main_arr1
	li $t1,0
	mul $t1,$t1,4
	add $t0,$t1,$t0
	lw $t0,($t0)
	li $v0,1
	la $a0,0($t0)
	syscall 	#print integer
	li $t0,2
	sw $t0,Main_main_a
	li $t1,1
	neg $t1,$t1
	sw $t1,Main_main_b
	lw $t3,Main_main_a
	lw $t4,Main_main_b
	sgt $t2,$t3,$t4
	beqz $t2,Main_main_out0
	lw $t2,Main_main_a
	li $v0,1
	la $a0,0($t2)
	syscall 	#print integer
	b Main_main_jump0
Main_main_out0:
	lw $t2,Main_main_b
	li $v0,1
	la $a0,0($t2)
	syscall 	#print integer
Main_main_jump0:
	li $t3,1
	li $t4,2
	sgt $t2,$t3,$t4
	li $t4,2
	li $t5,3
	slt $t3,$t4,$t5
	or $t4,$t2,$t3
	beqz $t4,Main_main_out1
	li $v0,4
	la $a0,CONSTANT0
	syscall 	#print string
Main_main_out1:
	li $t3,1
	li $t4,2
	sgt $t2,$t3,$t4
	li $t4,2
	li $t5,3
	slt $t3,$t4,$t5
	and $t4,$t2,$t3
	beqz $t4,Main_main_out2
	li $v0,4
	la $a0,CONSTANT1
	syscall 	#print string
Main_main_out2:
	li $t2,0
	sw $t2,Main_main_i
Main_main_loop0:
	lw $t4,Main_main_i
	li $t5,4
	sle $t3,$t4,$t5
	beqz $t3,Main_main_out3
	b Main_main_jump1
Main_main_jump2:
	lw $t4,Main_main_i
	li $t5,1
	add $t3,$t4,$t5
	sw $t3,Main_main_i
	b Main_main_loop0
Main_main_jump1:
	lw $t5,Main_main_i
	li $t6,0
	seq $t4,$t5,$t6
	beqz $t4,Main_main_out4
	b Main_main_jump2	#continue statement
Main_main_out4:
	lw $t4,Main_main_i
	li $v0,1
	la $a0,0($t4)
	syscall 	#print integer
	b Main_main_jump2
Main_main_out3:
Main_main_loop1:
	li $t4,1
	neg $t4,$t4
	lw $t6,Main_main_i
	sge $t5,$t6,$t4
	beqz $t5,Main_main_out5
	lw $t4,Main_main_i
	li $v0,1
	la $a0,0($t4)
	syscall 	#print integer
	lw $t5,Main_main_i
	li $t6,1
	sub $t4,$t5,$t6
	sw $t4,Main_main_i
	lw $t6,Main_main_i
	li $t7,0
	seq $t5,$t6,$t7
	beqz $t5,Main_main_out6
	li $v0,4
	la $a0,CONSTANT2
	syscall 	#print string
	b Main_main_out5	#break statement
Main_main_out6:
	b Main_main_loop1
Main_main_out5:
		.data
nl: .asciiz"\n"
BUFFER: .space 30
BUFFER_LEN: .word 30
NEW_LINE: .asciiz "\n"
Main_main_arr1: .word 0
Main_main_arr1_size: .word 0
Main_main_a: .word 0
Main_main_b: .word 0
CONSTANT0: .asciiz "or check"
CONSTANT1: .asciiz "and check"
Main_main_i: .word 0
CONSTANT2: .asciiz "in break"
