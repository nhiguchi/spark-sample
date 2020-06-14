package hoge

import org.apache.spark.{SparkConf, SparkContext}

object BasicWordCount {
  def main(args: Array[String]): Unit = {}

  // SparkContextの作成
  val conf = new SparkConf().setAppName("Basic WordCount")
  val sc = new SparkContext(conf)

  // Word Count
  val textFile = sc.textFile("/tmp/spark-README.md")
  val words = textFile.flatMap(line => line.split(" "))
  val wordCount = words.map(word => (word, 1)).reduceByKey((a, b) => a + b)

  // 処理結果出力
  wordCount.saveAsTextFile("./result")
}
