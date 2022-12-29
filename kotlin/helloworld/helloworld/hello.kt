fun main(args:Array<String>){
  print("Hello World")
    println("Hello World")
    println("Hello World")

  val a="CSMJU"
  var b=1234000000000000000

  b=4321
  var c:String
  c="Pater"

  println("A = ${a}  B = ${b} Size of A is ${a.length}")
 println(b::class.simpleName)
  val d="""hello\nw\jhkghncvhcg\"gfhfghfg'orld"""
  val e="""
    ปรัชญา

     ปรัชญาการศึกษาของมหาวิทยาลัย คือ
      “จัดการศึกษาเพื่อเสริมสร้างปัญญาในรูปแบบการเรียนรู้จากการปฏิบัติที่บูรณาการกับการทำงานตามอมตะโอวาท
       งานหนักไม่เคยฆ่าคน มุ่งให้ผู้เรียน มีทักษะการเรียนรู้ตลอดชีวิต สามารถพัฒนาทักษะเดิม สร้างเสริมทักษะใหม่
        มีวิธีคิดของการเป็นผู้ประกอบการ มีการใช้เทคโนโลยีดิจิทัลและการสื่อสาร มีความตระหนักต่อสังคม วัฒนธรรมและสิ่งแวดล้อม ยึดมั่นในความสัมพันธ์ระหว่างมหาวิทยาลัยกับชุมชน ตามจุดยืนของมหาวิทยาลัยแม่โจ้ ที่ว่า มหาวิทยาลัยแห่งชีวิต” (ที่ประชุมสภามหาวิทยาลัยแม่โจ้ ให้ความเห็นชอบ ในการประชุมครั้งที่ 7/2563 เมื่อวันที่ 8 กันยายน 2563 ตามรายละเอียดหนังสือที่ อว 68.1.1.2/ว142 ลงวันที่ 11 กันยายน 2563)


     ปรัชญาการศึกษาของหลักสูตร คือ “ผลิตบัณฑิตที่มีคุณธรรม จริยธรรม เป็นผู้นำ และสร้างสรรค์สังคมด้วยวิชาการ เชี่ยวชาญทางด้านวิทยาการคอมพิวเตอร์ และเทคโนโลยีสารสนเทศ” 
  """.trimIndent()
  println(e)
  var f="john";var g="pater"
  print(f==g)
// comment
  // array
  var array1= arrayOf(1,2,3,4)
println("${array1[0]} , ${array1[1]} , ${array1[2]*2}     ")
  var array2=Array<String>(5,init={i->"value at ${i}"})
  println(array2[0])
  println(array2[1])
  println(array2[2])
  println(array2[3])
  println(array2[4])

  var array3= arrayOfNulls<String>(10)
  array3[8]="abcd"
  println(array3[8])
  for((index,item) in array3.withIndex()){
    print("item at ${index+1}= ${item}" )
  }
  println()
 var list1= mutableListOf<String>("CS","MJU","MJU")
  list1.add(0,"Me")
  for (item in list1)println(item)

  var set1= mutableSetOf<String>("CS","MJU","MJU")
  for (item in set1)println(item)

  val text1="dfgdfgdfgdfhdfnjghkkj.kl;hjktydrgdfhdghdfsgfsgd"
  var set2= mutableSetOf<Char>()
  for (char in text1.toCharArray()){
    set2.add(char)
  }
   println(set2)
  var map1= mutableMapOf(Pair(1,"Thai"),Pair(2,"English"))
  map1.set(1,"German")
  println(map1.get(1))

}