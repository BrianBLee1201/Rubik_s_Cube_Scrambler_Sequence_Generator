# Rubik_s_Cube_Scrambler_Sequence_Generator
## Description
This app generates a move sequence from sizes 2x2 to 17x17. Unlike other types of scrambling sequences, it has an option to select a difficulty of a solve (easy - few moves to scramble, hard - more moves to scramble). In addition, there is a special notation I came up with when scrambling with cubers bigger than 3x3.
##Notation
To decipher the generated sequence, here is the legend:
```
B - Back Face
D - Down Face
F - Front Face
L - Left Face
R - Right Face
U - Up Face

(No notation after a selected face) - Turn it 90 Degrees Clockwise
' - Turn it 90 Degrees Counter-Clockwise
2 - Turn it 180 Degrees

*n*B - _n_ layers of Back Face
*n*D - _n_ layers of Down Face
*n*F - _n_ layers of Front Face
*n*L - _n_ layers of Left Face
*n*R - _n_ layers of Right Face
*n*U - _n_ layers of Up Face
```
Special moves such as M, E, S, X, Y, and Z are not included — these moves are very confusing in the generated sequence.
## Note
This is coded in Android Studio. The minimum requirement is the version Android 7.0, Pixel 2.0, API 24.
