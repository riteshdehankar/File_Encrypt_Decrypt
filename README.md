# File_Encrypt_Decrypt
This Java program provides a **GUI-based File Encryptor and Decryptor** using Swing. Users can select input and output files through a file chooser, then encrypt or decrypt content with a simple Caesar cipher (shifting characters by 3). It features a dark-themed interface, live status updates, and error handling for file operations.


🔐 FileEncryptDecryptGUI – File Encryption & Decryption Tool

The FileEncryptDecryptGUI is a Java Swing-based desktop application that allows users to easily encrypt and decrypt text files using a simple graphical interface. With its modern dark-themed UI 🎨, it offers a clean and efficient way to protect sensitive text data using a basic Caesar Cipher algorithm.

🌟 Key Features:-

🖥️ User-Friendly GUI:
Built with Java Swing and a stylish dark theme for a professional look and smooth interaction.

📂 Easy File Selection:
Users can browse and select input and output files using JFileChooser dialogs.

🔒 Encrypt & Decrypt Options:
Two dedicated buttons let users encrypt or decrypt any text file instantly.

🪄 Real-Time Status Updates:
A live status panel displays messages about operation progress, success ✅, or errors ❌.

⚠️ Error Handling:
Alerts users for missing files or invalid paths with friendly pop-up messages.

⚡ Lightweight & Fast:
Performs encryption and decryption in seconds with minimal system resources.

💻 Cross-Platform:
Works smoothly on any system with Java installed — Windows, macOS, or Linux.

⚙️ How It Works

👆 The user selects an input file and specifies an output location.

🔘 Clicking Encrypt or Decrypt triggers the selected operation.

📖 The program reads the input file character by character.

🔁 Each character is shifted based on the Caesar Cipher algorithm.

💾 The modified text is saved to the output file.

📝 Status area confirms completion or shows any errors.

🧮 Algorithm Used – Caesar Cipher

The application uses the Caesar Cipher algorithm, one of the simplest and earliest encryption techniques.

Encryption (E): Each character’s ASCII value is increased by +3.
➕ Formula → EncryptedChar = OriginalChar + 3

Decryption (D): Each character’s ASCII value is decreased by -3.
➖ Formula → DecryptedChar = EncryptedChar - 3

Although basic, this algorithm is perfect for demonstrating encryption logic and secure file transformation concepts.

🏁 Conclusion

The 🔐 FileEncryptDecryptGUI project beautifully combines GUI design, file handling, and encryption logic in one interactive tool. It’s a great beginner-friendly project to learn about Java Swing, I/O operations, and cryptography fundamentals, all while ensuring a smooth and visually appealing user experience. 🚀
