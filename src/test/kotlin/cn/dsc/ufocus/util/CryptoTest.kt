// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-18

package cn.dsc.ufocus.util

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.encrypt.Encryptors
import org.springframework.security.crypto.keygen.KeyGenerators

class CryptoTest {

    /**
     * 字节加密器
     */
    @Test
    fun byte() {
        val password = "HGKAIDNFKJADS"  // 加密密码
        val salt = "9999"               // 盐
        val encryptor = Encryptors.stronger(password, salt)

        val contextArray = "123456".toByteArray()
        val text = encryptor.encrypt(contextArray)

        val bytes = encryptor.decrypt(text)
        println("再解密：${String(bytes)}")
    }

    /**
     * 文本加密器
     */
    @Test
    fun text() {
        val password = "HGKAIDNFKJADS"  // 加密密码
        val salt = "9999"               // 盐
        val encryptors = Encryptors.text(password, salt)

        val context = "123456"          // 加密前文本
        val text = encryptors.encrypt(context)
        println("加密后：$text")

        val decrypt = encryptors.decrypt(text)
        println("再解密：$decrypt")
    }

    /**
     * 密钥生成器
     */
    @Test
    fun keyGenerator() {
        val generator = KeyGenerators.secureRandom()
        val key = generator.generateKey()
        // 默认生成的 key 是 8 bytes
    }

    @Test
    fun keyGeneratorLength() {
        val generator = KeyGenerators.secureRandom(16)
        val key = generator.generateKey()
    }

    /**
     * 直接生成字符串密钥
     */
    @Test
    fun stringKeyGenerator() {
        val stringGenerator = KeyGenerators.string()
        val key = stringGenerator.generateKey()
        println("生成字符串密钥：$key")
    }
}