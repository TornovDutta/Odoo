"use client";
import React from "react";
import Image from "next/image";
import Link from "next/link";
import logo_img from "../../public/odoo/odoo_logo.png";

const Navbar = () => {
  const [opsOpen, setOpsOpen] = React.useState(false);
  const opsRef = React.useRef(null);

  React.useEffect(() => {
    function handleOutside(e) {
      if (opsRef.current && !opsRef.current.contains(e.target)) {
        setOpsOpen(false);
      }
    }
    document.addEventListener("mousedown", handleOutside);
    return () => document.removeEventListener("mousedown", handleOutside);
  }, []);

  return (
    <header className="text-gray-600 body-font">
      <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        <Link
          href="/"
          className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0"
        >
          <Image src={logo_img} alt="Logo" width={100} height={100} />
        </Link>

        <nav className="md:mr-auto md:ml-4 md:py-1 md:pl-4 md:border-l md:border-gray-400 flex flex-wrap items-center text-base justify-center">
          <a className="mr-5 hover:text-gray-900">Dashboard</a>
          <Link href="/products" className="mr-5 hover:text-gray-900">
            Products
          </Link>

          <div ref={opsRef} className="relative mr-5">
            <button
              onClick={() => setOpsOpen((s) => !s)}
              className="inline-flex items-center hover:text-gray-900 focus:outline-none"
              aria-expanded={opsOpen}
              aria-haspopup="true"
            >
              Operations
              <svg
                className="w-4 h-4 ml-1"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                viewBox="0 0 24 24"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M19 9l-7 7-7-7"
                />
              </svg>
            </button>

            {opsOpen && (
              <div className="absolute left-0 mt-2 w-40 bg-white rounded-md shadow-lg ring-1 ring-gray-300 ring-opacity-50 z-20">
                <div className="py-1" role="menu" aria-orientation="vertical">
                  <Link
                    href="/receipt"
                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                  >
                    Receipt
                  </Link>
                  <Link
                    href="/operations/delivery"
                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                  >
                    Delivery
                  </Link>
                </div>
              </div>
            )}
          </div>

          <Link href="/stock" className="mr-5 hover:text-gray-900">
            Stock
          </Link>
          <a className="mr-5 hover:text-gray-900">Move History</a>
          <a className="mr-5 hover:text-gray-900">Settings</a>
        </nav>

        <button className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">
          Login
          <svg
            fill="none"
            stroke="currentColor"
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth="2"
            className="w-4 h-4 ml-1"
            viewBox="0 0 24 24"
          >
            <path d="M5 12h14M12 5l7 7-7 7"></path>
          </svg>
        </button>
      </div>
    </header>
  );
};

export default Navbar;
