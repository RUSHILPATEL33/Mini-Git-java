# MyGit 🚀

A mini Git-like Version Control System built in Java to understand how real version control systems work internally.

## 📌 About The Project

MyGit is a simplified implementation of core Git concepts such as:

* Object Storage
* SHA-1 Hashing
* Staging Area
* Commit Snapshots
* Commit History
* Checkout / Restore
* HEAD Tracking

This project was built as a systems programming side quest to deeply understand the internal architecture of version control systems.

---

# ⚙️ Features

✅ Initialize repository
✅ Add files to staging area
✅ Store objects using SHA-1 hashes
✅ Create commits
✅ View commit history
✅ Restore old versions using checkout
✅ Track current repository state using HEAD

---

# 🧠 Concepts Learned

This project helped explore:

* File System Operations
* Content Addressable Storage
* Snapshot-based Versioning
* Command Line Interface Design
* Modular Software Architecture
* Repository State Management
* Hashing Algorithms

---

# 🏗️ Project Structure

```bash
MyGit/
│
├── src/
│   ├── commands/
│   │   ├── AddCommand.java
│   │   ├── CommitCommand.java
│   │   ├── LogCommand.java
│   │   ├── StatusCommand.java
│   │   └── CheckoutCommand.java
│   │
│   ├── utils/
│   │   └── HashUtil.java
│   │
│   └── Main.java
│
├── .mygit/
│   ├── objects/
│   ├── commits/
│   ├── index
│   └── HEAD
│
└── README.md
```

---

# 🔨 Commands

## Initialize Repository

```bash
java Main init
```

---

## Add File

```bash
java Main add hello.txt
```

Stores file contents inside `.mygit/objects/` using SHA-1 hashing.

---

## Commit Changes

```bash
java Main commit "first commit"
```

Creates a snapshot of staged files.

---

## View Commit History

```bash
java Main log
```

Displays all commits and metadata.

---

## Repository Status

```bash
java Main status
```

Shows currently staged files.

---

## Restore Previous Version

```bash
java Main checkout <commit-id>
```

Restores files from a previous commit snapshot.

---

# 🧩 Internal Working

## Object Storage

Files are stored as hashed objects:

```text
SHA-1 Hash -> File Contents
```

Example:

```text
f672313e... -> Hello MyGit
```

---

## Commit System

Each commit stores:

* Commit Message
* Timestamp
* File → Object Hash Mapping

Example:

```text
hello.txt:f672313e...
```

---

## HEAD Tracking

The current active commit is stored inside:

```text
.mygit/HEAD
```

This allows repository state tracking and future history navigation.

---

# 🚀 Future Improvements

* Parent Commits
* Branching
* Merge Support
* Diff Algorithm
* Remote Repositories
* Better Status Tracking

---

# 💻 Tech Stack

* Java
* File System APIs
* SHA-1 Hashing
* CLI-based Architecture

---

# 🎯 Purpose

This project was built to learn the internals of Git and strengthen understanding of backend/system-level software engineering concepts.

---

# ⭐ Inspiration

Inspired by the internal architecture of Git and the curiosity to understand how developer tools actually work under the hood.
