<script lang="ts">
    import "../app.css";
    import { Icon } from "svelte-awesome";
    import { github } from "svelte-awesome/icons";
    const year = new Date().getFullYear();
</script>

<div class="bg-gray-900">
    <nav id="header" class="bg-black w-full z-30 top-0 py-1">
        <div class="w-full container mx-auto flex flex-wrap items-center justify-between mt-0 px-6 py-3">
            <label for="menu-toggle" class="cursor-pointer md:hidden block">
                <svg
                    class="fill-current text-gray-900"
                    xmlns="http://www.w3.org/2000/svg"
                    width="20"
                    height="20"
                    viewBox="0 0 20 20"
                >
                    <title>menu</title>
                    <path d="M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z" />
                </svg>
            </label>
            <input class="hidden" type="checkbox" id="menu-toggle" />

            <div class="hidden md:flex md:items-center md:w-auto w-full order-3 md:order-1" id="menu">
                <nav>
                    <ul class="md:flex items-center justify-between text-base pt-4 md:pt-0">
                        <li><a class="inline-block no-underline hover:text-amber-700 py-2 pr-4" href="/">Index</a></li>
                    </ul>
                </nav>
            </div>

            <div class="order-1 md:order-2">PWGEN</div>

            <div class="order-2 md:order-3 flex items-center" id="nav-content" />
        </div>
    </nav>

    <div class="container mx-auto">
        <div class="overflow-hidden w-full px-6 pt-4" style="min-height: 1000px">
            <slot />
        </div>
    </div>
</div>

<footer class="container mx-auto py-8">
    <div class="container flex px-3 py-8 ">
        <div class="w-full mx-auto flex flex-wrap">
            <div class="flex w-full lg:w-1/2 ">
                <div class="px-3 md:px-0">
                    <h3 class="font-bold">About</h3>
                    <p class="py-4 text-gray-400">
                        PWGEN is a web tool for password generation. <br />
                        &copy; PWGEN {year}
                    </p>
                </div>
            </div>
            <div class="flex w-full lg:w-1/2 lg:justify-end lg:text-right">
                <div class="px-3 md:px-0">
                    <h3 class="font-bold">Social</h3>
                    <ul class="list-reset items-center pt-3">
                        <li>
                            <a
                                class="inline-block no-underline hover:text-amber-700 py-1 text-lg text-gray-400 inline-block align-middle"
                                href="https://github.com/Implex1v/pwgen"
                            >
                                <span>GitHub</span>
                                <Icon data={github} scale="1.1" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
