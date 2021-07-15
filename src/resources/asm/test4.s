		.text
		.globl main
main:
	lw $t0,Main_main_num3
	add $t0,$t0,1
	sw $t0,Main_main_num3
	lw $t0,Main_main_num3
	li $v0,1
	la $a0,0($t0)
	syscall 	#print integer
	lw $t1,Main_main_num3
	li $t2,32
	add $t0,$t1,$t2
	li $t2,6
	rem $t1,$t0,$t2
	sw $t1,Main_main_num4
	lw $t0,Main_main_num4
	li $v0,1
	la $a0,0($t0)
	syscall 	#print integer
	li.s $f0,2.45
	swc1 $f0,Main_main_real1
	li $t0,1
	sb $t0,Main_main_bool1
	li $v0,4
	la $a0,NEW_LINE
	syscall 	#line feed
	lw $t2,Main_main_num3
	add $t2,$t2,1
	sw $t2,Main_main_num3
	lw $t2,Main_main_num3
	li $v0,1
	la $a0,0($t2)
	syscall 	#print integer
	li $v0,4
	la $a0,NEW_LINE
	syscall 	#line feed
	lwc1 $f10,Main_main_real1
	cvt.w.s $f10,$f10
	mfc1.d $t2,$f10
	sw $t2,Main_main_realToIntVar
	lw $t3,Main_main_realToIntVar
	li $v0,1
	la $a0,0($t3)
	syscall 	#print integer
	li $v0,4
	la $a0,NEW_LINE
	syscall 	#line feed
	lwc1 $f10,Main_main_real1
	swc1 $f10,Main_main_implicitRealToIntVar
	lw $t3,Main_main_implicitRealToIntVar
	li $v0,1
	la $a0,0($t3)
	syscall 	#print integer
	li $t3,5
	sw $t3,Main_main_num5
	lw $t5,Main_main_num5
	li $t6,3
	and $t4,$t5,$t6
	sw $t4,Main_main_bitwise1
	lw $t6,Main_main_num5
	li $t7,3
	or $t5,$t6,$t7
	sw $t5,Main_main_bitwise2
	lw $t6,Main_main_bitwise1
	li $v0,1
	la $a0,0($t6)
	syscall 	#print integer
	lw $t6,Main_main_bitwise2
	li $v0,1
	la $a0,0($t6)
	syscall 	#print integer
		.data
nl: .asciiz"\n"
BUFFER: .space 30
BUFFER_LEN: .word 30
NEW_LINE: .asciiz "\n"
Main_main_num3: .word 0
Main_main_num4: .word 0
Main_main_bool1: .byte 0
Main_main_real1: .float 0.0
Main_main_realToIntVar: .word 0
Main_main_implicitRealToIntVar: .word 0
Main_main_bitwise1: .word 0
Main_main_bitwise2: .word 0
Main_main_num5: .word 0
