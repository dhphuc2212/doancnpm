-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 25, 2021 lúc 09:22 AM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlytiempho`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--
CREATE DATABASE `quanlytiempho`;
USE `quanlytiempho`;
CREATE TABLE `ban` (
  `idban` int(11) NOT NULL,
  `Loaiban` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`idban`, `Loaiban`, `trangthai`) VALUES
(1, 'Lớn', 'Có người'),
(2, 'Nhỏ', 'Có người'),
(3, 'Lớn', 'Trống'),
(4, 'Lớn', 'Trống'),
(5, 'Nhỏ', 'Trống'),
(6, 'Nhỏ', 'Trống'),
(7, 'Lớn', 'Trống'),
(8, 'Nhỏ', 'Trống'),
(9, 'Lớn', 'Trống'),
(10, 'Nhỏ', 'Trống'),
(11, 'Lớn', 'Trống'),
(12, 'Nhỏ', 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `idchitiethoadon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idhoadon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idto` int(11) NOT NULL,
  `loaito` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` decimal(10,0) NOT NULL,
  `tenmonphu` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `soluongmonphu` int(11) NOT NULL,
  `dongiamonphu` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`idchitiethoadon`, `idhoadon`, `idto`, `loaito`, `dongia`, `tenmonphu`, `soluongmonphu`, `dongiamonphu`) VALUES
('CTHD01', 'HD01', 9, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD101', 'HD31', 6, 'Tô đặc biệt', '75000', 'Hột gà', 1, '5000'),
('CTHD11', 'HD01', 9, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD111', 'HD31', 4, 'Tô nhỏ', '45000', '7 up', 1, '11000'),
('CTHD121', 'HD31', 1, 'Tô nhỏ', '45000', 'Bánh phở thêm', 1, '10000'),
('CTHD131', 'HD31', 8, 'Tô nhỏ', '45000', 'Bánh phở thêm', 1, '10000'),
('CTHD141', 'HD31', 2, 'Tô nhỏ', '45000', 'Coca', 1, '11000'),
('CTHD151', 'HD31', 4, 'Tô nhỏ', '45000', 'Coca', 1, '11000'),
('CTHD161', 'HD31', 4, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD171', 'HD31', 7, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD181', 'HD31', 8, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD191', 'HD31', 1, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD201', 'HD31', 4, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD21', 'HD01', 9, 'Tô nhỏ', '45000', 'Xá xị', 1, '11000'),
('CTHD211', 'HD31', 7, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD221', 'HD31', 8, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD231', 'HD31', 4, 'Tô nhỏ', '45000', 'Tiết hột gà', 1, '15000'),
('CTHD241', 'HD31', 4, 'Tô nhỏ', '45000', 'Xá xị', 1, '11000'),
('CTHD251', 'HD61', 3, 'Tô lớn', '60000', 'Bánh phở thêm', 1, '10000'),
('CTHD261', 'HD61', 2, 'Tô lớn', '60000', 'Quẩy', 2, '5000'),
('CTHD271', 'HD61', 1, 'Tô nhỏ', '45000', 'Quẩy', 2, '5000'),
('CTHD281', 'HD71', 5, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD291', 'HD71', 5, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD301', 'HD81', 3, 'Tô nhỏ', '45000', 'Bánh phở thêm', 1, '10000'),
('CTHD31', 'HD11', 9, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD311', 'HD81', 4, 'Tô nhỏ', '45000', 'Bánh phở thêm', 1, '10000'),
('CTHD321', 'HD81', 2, 'Tô nhỏ', '45000', 'Coca', 2, '11000'),
('CTHD331', 'HD81', 2, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD341', 'HD81', 1, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD351', 'HD81', 3, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD361', 'HD81', 1, 'Tô nhỏ', '45000', 'Xá xị', 1, '11000'),
('CTHD371', 'HD91', 1, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD381', 'HD111', 2, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD41', 'HD11', 9, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD51', 'HD11', 9, 'Tô nhỏ', '45000', 'Xá xị', 1, '11000'),
('CTHD61', 'HD21', 9, 'Tô nhỏ', '45000', 'Hột gà', 1, '5000'),
('CTHD71', 'HD21', 9, 'Tô nhỏ', '45000', 'Quẩy', 1, '5000'),
('CTHD81', 'HD21', 9, 'Tô nhỏ', '45000', 'Xá xị', 1, '11000'),
('CTHD91', 'HD31', 6, 'Tô đặc biệt', '75000', 'Bánh phở thêm', 2, '10000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietmonphu`
--

CREATE TABLE `chitietmonphu` (
  `id` int(11) NOT NULL,
  `idto` int(11) NOT NULL,
  `idmonphu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietmonphu`
--

INSERT INTO `chitietmonphu` (`id`, `idto`, `idmonphu`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `idhoadon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idban` int(11) NOT NULL,
  `ngayxuat` date NOT NULL,
  `idthuckhach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gioxuat` time NOT NULL,
  `idnhanvien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tongtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`idhoadon`, `idban`, `ngayxuat`, `idthuckhach`, `gioxuat`, `idnhanvien`, `tongtien`) VALUES
('HD01', 9, '2021-05-18', 'TK2', '21:03:13', 'NV2', 66000),
('HD101', 1, '2021-05-21', 'TK1', '12:49:55', 'NV2', 0),
('HD11', 9, '2021-05-18', 'TK2', '21:10:04', 'NV2', 66000),
('HD111', 2, '2021-09-20', 'TK2', '12:05:56', 'NV2', 50000),
('HD21', 9, '2021-05-18', 'TK2', '21:12:04', 'NV2', 66000),
('HD31', 1, '2021-05-21', 'TK1', '07:39:50', 'NV2', 574000),
('HD41', 2, '2021-05-21', 'TK3', '08:56:34', 'NV2', 0),
('HD51', 2, '2021-05-21', 'TK3', '08:56:56', 'NV2', 0),
('HD61', 1, '2021-05-21', 'TK2', '08:57:03', 'NV2', 195000),
('HD71', 2, '2021-05-21', 'TK2', '12:43:16', 'NV2', 100000),
('HD81', 1, '2021-05-21', 'TK1', '12:43:30', 'NV2', 338000),
('HD91', 2, '2021-05-21', 'TK2', '12:47:05', 'NV2', 50000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaimonphu`
--

CREATE TABLE `loaimonphu` (
  `id` int(11) NOT NULL,
  `tenloai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaimonphu`
--

INSERT INTO `loaimonphu` (`id`, `tenloai`) VALUES
(1, 'thức ăn'),
(2, 'thức uống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monphu`
--

CREATE TABLE `monphu` (
  `idmonphu` int(11) NOT NULL,
  `Tenmonphu` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Giatien` decimal(10,0) NOT NULL,
  `idloaimonphu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `monphu`
--

INSERT INTO `monphu` (`idmonphu`, `Tenmonphu`, `Giatien`, `idloaimonphu`) VALUES
(1, 'Quẩy', '5000', 1),
(2, 'Hột gà', '5000', 1),
(3, 'Bánh phở thêm', '10000', 1),
(4, 'Tiết', '10000', 1),
(5, 'Tiết hột gà', '15000', 1),
(6, 'Coca', '11000', 2),
(7, 'Xá xị', '11000', 2),
(8, '7 up', '11000', 2),
(9, 'Lipton', '11000', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `idnhanvien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tennhanvien` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dienthoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `diachi` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`idnhanvien`, `tennhanvien`, `dienthoai`, `ngaysinh`, `diachi`) VALUES
('NV1', 'Phạm Văn A', '077926738', '1996-01-08', '12/6'),
('NV2', 'Trần Văn A', '077926737', '1995-02-25', '12/7');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `id` int(11) NOT NULL,
  `tenquyen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ghichu` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`id`, `tenquyen`, `ghichu`) VALUES
(1, 'nhân viên', ''),
(2, 'admin', ''),
(3, 'quản lý', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `idtaikhoan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tentaikhoan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idnhanvien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maquyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`idtaikhoan`, `tentaikhoan`, `matkhau`, `idnhanvien`, `maquyen`) VALUES
('TAK2', 'nhanvien', 'e10adc3949ba59abbe56e057f20f883e', 'NV1', 1),
('TAK3', 'quanly', 'e10adc3949ba59abbe56e057f20f883e', 'NV2', 3),
('TAK4', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuckhach`
--

CREATE TABLE `thuckhach` (
  `idthuckhach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idban` int(11) NOT NULL,
  `Loaithuckhach` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `giovao` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thuckhach`
--

INSERT INTO `thuckhach` (`idthuckhach`, `idban`, `Loaithuckhach`, `giovao`) VALUES
('TK1', 1, 'Nhiều người', '12:52:06'),
('TK2', 2, 'Một người', '14:00:33');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `topho`
--

CREATE TABLE `topho` (
  `idto` int(11) NOT NULL,
  `Loaithit` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Loaito` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `idthuckhach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `giatien` decimal(10,0) DEFAULT NULL,
  `giodat` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `topho`
--

INSERT INTO `topho` (`idto`, `Loaithit`, `Loaito`, `idthuckhach`, `giatien`, `giodat`) VALUES
(1, 'Tái Nạm ', 'Tô nhỏ', 'TK1', '45000', '13:33:14');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`idban`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`idchitiethoadon`),
  ADD KEY `cthd1` (`idhoadon`),
  ADD KEY `cthd2` (`idto`);

--
-- Chỉ mục cho bảng `chitietmonphu`
--
ALTER TABLE `chitietmonphu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ctmp2` (`idmonphu`),
  ADD KEY `ctmp1` (`idto`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`idhoadon`),
  ADD KEY `hd1` (`idban`),
  ADD KEY `hd2` (`idnhanvien`),
  ADD KEY `hd3` (`idthuckhach`);

--
-- Chỉ mục cho bảng `loaimonphu`
--
ALTER TABLE `loaimonphu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `monphu`
--
ALTER TABLE `monphu`
  ADD PRIMARY KEY (`idmonphu`),
  ADD KEY `mp1` (`idloaimonphu`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`idnhanvien`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`idtaikhoan`),
  ADD KEY `pq1` (`maquyen`);

--
-- Chỉ mục cho bảng `thuckhach`
--
ALTER TABLE `thuckhach`
  ADD PRIMARY KEY (`idthuckhach`),
  ADD KEY `tk1` (`idban`);

--
-- Chỉ mục cho bảng `topho`
--
ALTER TABLE `topho`
  ADD PRIMARY KEY (`idto`),
  ADD KEY `tp1` (`idthuckhach`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `cthd1` FOREIGN KEY (`idhoadon`) REFERENCES `hoadon` (`idhoadon`);

--
-- Các ràng buộc cho bảng `chitietmonphu`
--
ALTER TABLE `chitietmonphu`
  ADD CONSTRAINT `ctmp1` FOREIGN KEY (`idto`) REFERENCES `topho` (`idto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctmp2` FOREIGN KEY (`idmonphu`) REFERENCES `monphu` (`idmonphu`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hd1` FOREIGN KEY (`idban`) REFERENCES `ban` (`idban`),
  ADD CONSTRAINT `hd2` FOREIGN KEY (`idnhanvien`) REFERENCES `nhanvien` (`idnhanvien`);

--
-- Các ràng buộc cho bảng `monphu`
--
ALTER TABLE `monphu`
  ADD CONSTRAINT `mp1` FOREIGN KEY (`idloaimonphu`) REFERENCES `loaimonphu` (`id`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `pq1` FOREIGN KEY (`maquyen`) REFERENCES `phanquyen` (`id`);

--
-- Các ràng buộc cho bảng `thuckhach`
--
ALTER TABLE `thuckhach`
  ADD CONSTRAINT `tk1` FOREIGN KEY (`idban`) REFERENCES `ban` (`idban`);

--
-- Các ràng buộc cho bảng `topho`
--
ALTER TABLE `topho`
  ADD CONSTRAINT `tp1` FOREIGN KEY (`idthuckhach`) REFERENCES `thuckhach` (`idthuckhach`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
